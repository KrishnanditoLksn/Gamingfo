package app.ditsdev.core.data.source.remote

import android.annotation.SuppressLint
import app.ditsdev.core.BuildConfig
import app.ditsdev.core.data.source.remote.network.ApiService
import app.ditsdev.core.data.source.remote.network.responses.GamesItemResponse
import app.ditsdev.core.data.result.api.ApiResponseResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

class RemoteGameDataSource(private val apiService: ApiService) {

    @SuppressLint("CheckResult")
    fun getAllGames(): Flowable<ApiResponseResult<List<GamesItemResponse>>> {
        val resultData = PublishSubject.create<ApiResponseResult<List<GamesItemResponse>>>()

        val client = apiService.getAllGames(BuildConfig.API_KEY)
        client.subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({
                val datas = it.results
                resultData.onNext(if (datas.isNotEmpty()) ApiResponseResult.Success(datas) else ApiResponseResult.Empty)
            }, { error ->
                resultData.onNext(ApiResponseResult.Error(error.message.toString()))
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }
}