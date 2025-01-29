package app.ditsdev.core.domain.usecase

import app.ditsdev.core.domain.model.Game
import app.ditsdev.core.data.result.resource.ResourceResult
import io.reactivex.rxjava3.core.Flowable

interface GameUseCase {
    fun getAllGames():Flowable<ResourceResult<List<Game>>>
    fun getFavoriteGames():Flowable<List<Game>>
    fun setFavoriteGames(game:Game,state:Boolean)

    fun searchGames(params:String):Flowable<List<Game>>
}