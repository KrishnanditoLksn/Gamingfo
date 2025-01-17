package app.ditsdev.core.resources

import app.ditsdev.core.result.api.ApiResponseResult
import app.ditsdev.core.result.resource.ResourceResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

abstract class NetworkBoundResources<ResultType : Any, RequestType> {
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
        val apiResponse = createCall()

        result.onNext(ResourceResult.Loading(null))

        val response = apiResponse
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .doOnComplete {
                mCompositeDisposable.dispose()
            }
            .subscribe { response ->
                when (response) {
                    is ApiResponseResult.Success -> {
                        saveCallResult(response.data)
                        val dbSource = loadFromDB()
                        val subscribe = dbSource.subscribeOn(Schedulers.computation())
                            .observeOn(AndroidSchedulers.mainThread())
                            .take(1)
                            .subscribe {
                                result.onNext(ResourceResult.Success(it))
                            }
                        subscribe.dispose()
                    }

                    is ApiResponseResult.Empty -> {
                        val dbSource = loadFromDB()
                        val subscribe = dbSource.subscribeOn(Schedulers.computation())
                            .observeOn(AndroidSchedulers.mainThread())
                            .take(1)
                            .subscribe {
                                result.onNext(ResourceResult.Success(it))
                            }
                        subscribe.dispose()
                    }

                    is ApiResponseResult.Error -> {
                        onFetchFailed()
                        result.onNext(ResourceResult.Error(response.errorMessage))
                    }
                }
            }
        mCompositeDisposable.add(response)
    }
}