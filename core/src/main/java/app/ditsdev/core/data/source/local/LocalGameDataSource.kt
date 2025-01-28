package app.ditsdev.core.data.source.local

import app.ditsdev.core.data.source.local.dao.GameDao
import app.ditsdev.core.data.source.local.entity.GameEntity
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