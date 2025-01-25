package app.ditsdev.core.domain.repository.publisher

import app.ditsdev.core.domain.model.Publisher
import app.ditsdev.core.remote.network.responses.ResultsItem
import app.ditsdev.core.remote.source.publisher.LocalPublisherDataSource
import app.ditsdev.core.remote.source.publisher.RemotePublisherDataSource
import app.ditsdev.core.resources.NetworkBoundResources
import app.ditsdev.core.result.api.ApiResponseResult
import app.ditsdev.core.result.resource.ResourceResult
import app.ditsdev.core.utils.AppExecutor
import app.ditsdev.core.utils.DataMapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

class PublisherRepository(
    private val remotePublisherDataSource: RemotePublisherDataSource,
    private val appExecutor: AppExecutor,
    private val localPublisherDataSource: LocalPublisherDataSource
) : ImplPublisherRepository {
    override fun getAllPublisher(): Flowable<ResourceResult<List<Publisher>>> {
        return object : NetworkBoundResources<List<Publisher>, List<ResultsItem>>(appExecutor) {
            override fun loadFromDB(): Flowable<List<Publisher>> {
                return localPublisherDataSource.displayPublisher().map {
                    DataMapper.mapPublisherEntitiesToDomain(it)
                }
            }

            override fun createCall(): Flowable<ApiResponseResult<List<ResultsItem>>> {
                return remotePublisherDataSource.getAllPublisher()
            }

            override fun saveCallResult(data: List<ResultsItem>) {
                localPublisherDataSource.insertPublisher(
                    DataMapper.mapPublisherResponseToEntity(
                        data
                    )
                )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }

            override fun shouldFetch(data: List<Publisher>?): Boolean {
                return data.isNullOrEmpty()
            }

        }.asFlowable()
    }

}