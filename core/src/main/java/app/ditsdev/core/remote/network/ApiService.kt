package app.ditsdev.core.remote.network

import app.ditsdev.core.remote.network.responses.GameResponse
import app.ditsdev.core.remote.network.responses.PublisherResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("games")
    fun getAllGames(
        @Query("apiKey")
        apiKey: String
    )
            : Flowable<GameResponse>

    @GET("games/{id}")
    fun getDetailGame(
        @Path("id")
        id: String,
        @Query("apiKey")
        apiKey: String
    ): Flowable<GameResponse>

    @GET("publishers")
    fun getAllPublisher(
        @Query("apiKey")
        apiKey: String
    ): Flowable<PublisherResponse>

    @GET("publishers/{id}")
    fun getDetailPublisher(
        @Path("id")
        id: String,
        @Query("apiKey")
        apiKey: String
    ): Flowable<PublisherResponse>

}