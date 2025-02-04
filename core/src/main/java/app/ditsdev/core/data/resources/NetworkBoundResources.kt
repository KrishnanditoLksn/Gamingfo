package app.ditsdev.core.data.resources

import app.ditsdev.core.data.result.api.ApiResponseResult
import app.ditsdev.core.data.result.resource.ResourceResult
import app.ditsdev.core.utils.AppExecutor
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

abstract class NetworkBoundResources<ResultType : Any, RequestType>(private val appExecutor: AppExecutor) {
    private val result = PublishSubject.create<ResourceResult<ResultType>>()
    private val mCompositeDisposable = CompositeDisposable()

    init {
        @Suppress("LeakingThis")
        val dbSource = loadFromDB()
        val db = dbSource
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe { value ->
                if (shouldFetch(value)) {
                    fetchFromNetwork()
                } else {
                    result.onNext(ResourceResult.Success(value))
                }
            }
        mCompositeDisposable.add(db)
    }

    private fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flowable<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun createCall(): Flowable<ApiResponseResult<RequestType>>

    protected abstract fun saveCallResult(data: RequestType)

    private fun fetchFromNetwork() {
        result.onNext(ResourceResult.Loading(null))
        val responseDisposable = createCall()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({ response ->
                when (response) {
                    is ApiResponseResult.Success -> {
                        saveCallResult(response.data)
                        val dbDisposable = loadFromDB()
                            .subscribeOn(Schedulers.computation())
                            .observeOn(AndroidSchedulers.mainThread())
                            .take(1)
                            .subscribe({ data ->
                                result.onNext(ResourceResult.Success(data))
                            }, { error ->
                                result.onNext(
                                    ResourceResult.Error(
                                        error.message
                                            ?: "Terjadi kesalahan saat mengambil data dari database",
                                        null
                                    )
                                )
                            })
                        mCompositeDisposable.add(dbDisposable)
                    }

                    is ApiResponseResult.Empty -> {
                        val dbDisposable = loadFromDB()
                            .subscribeOn(Schedulers.computation())
                            .observeOn(AndroidSchedulers.mainThread())
                            .take(1)
                            .subscribe({ data ->
                                result.onNext(ResourceResult.Success(data))
                            }, { error ->
                                result.onNext(
                                    ResourceResult.Error(
                                        error.message
                                            ?: "Terjadi kesalahan saat mengambil data dari database",
                                        null
                                    )
                                )
                            })

                        mCompositeDisposable.add(dbDisposable)
                    }

                    is ApiResponseResult.Error -> {
                        onFetchFailed()
                        result.onNext(ResourceResult.Error(response.errorMessage, null))
                    }
                }
            }, { error ->
                result.onNext(ResourceResult.Error(error.message ?: "Terjadi kesalahan", null))
            })
        mCompositeDisposable.add(responseDisposable)
    }

    fun asFlowable(): Flowable<ResourceResult<ResultType>> {
        return result.toFlowable(BackpressureStrategy.BUFFER)
    }
}