package app.ditsdev.core.remote.source.game

import app.ditsdev.core.local.dao.GameDao
import app.ditsdev.core.local.entity.GameEntity
import io.reactivex.rxjava3.core.Flowable

class LocalGameDataSource(private val gameDao: GameDao) {
    fun getAllGames(): Flowable<List<GameEntity>> = gameDao.getAllGames()
    fun getFavoriteGame(): Flowable<List<GameEntity>> = gameDao.getFavoriteGames()

    fun setFavoriteGame(game: GameEntity, currentState: Boolean) {
        game.isFavorite = currentState
        gameDao.updateFavoriteGame(game)
    }

    fun insertGame(game: List<GameEntity>) = gameDao.insertGame(game)

    fun searchGames(params: String) = gameDao.searchGames(params)
}