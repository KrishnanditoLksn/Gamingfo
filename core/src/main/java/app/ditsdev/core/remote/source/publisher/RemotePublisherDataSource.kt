package app.ditsdev.core.remote.source.publisher

import android.annotation.SuppressLint
import app.ditsdev.core.BuildConfig
import app.ditsdev.core.remote.network.ApiService
import app.ditsdev.core.remote.network.responses.ResultsItem
import app.ditsdev.core.result.api.ApiResponseResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

class RemotePublisherDataSource(private val apiService: ApiService) {

    @SuppressLint("CheckResult")
    fun getAllPublisher(): Flowable<ApiResponseResult<List<ResultsItem>>> {
        val resultsData = PublishSubject.create<ApiResponseResult<List<ResultsItem>>>()
        val client = apiService.getAllPublisher(BuildConfig.API_KEY)
        client.subscribeOn(
            Schedulers.computation()
        )
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({
                val pubDatas = it.results
                resultsData.onNext(if (pubDatas.isNotEmpty()) ApiResponseResult.Success(pubDatas) else ApiResponseResult.Empty)
            }, { err ->
                resultsData.onNext(ApiResponseResult.Error(err.message.toString()))
            })
        return resultsData.toFlowable(BackpressureStrategy.BUFFER)
    }
}