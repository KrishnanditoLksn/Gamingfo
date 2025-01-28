package app.ditsdev.core.domain.repository.game

import app.ditsdev.core.domain.model.Game
import app.ditsdev.core.result.resource.ResourceResult
import io.reactivex.rxjava3.core.Flowable

interface ImplGameRepository {
    fun getAllGames(): Flowable<ResourceResult<List<Game>>>
    fun getFavoriteGames(): Flowable<List<Game>>
    fun setFavoriteGames(game: Game, state: Boolean)

    fun searchGames(params: String): Flowable<List<Game>>
}