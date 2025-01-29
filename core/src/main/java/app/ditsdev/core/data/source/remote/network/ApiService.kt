package app.ditsdev.core.data.source.remote.network

import app.ditsdev.core.data.source.remote.network.responses.GameResponse
import app.ditsdev.core.data.source.remote.network.responses.PublisherResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    fun getAllGames(
        @Query("key")
        key: String
    )
            : Flowable<GameResponse>

    @GET("publishers")
    fun getAllPublisher(
        @Query("key")
        key: String
    ): Flowable<PublisherResponse>
}