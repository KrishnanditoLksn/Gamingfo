package app.ditsdev.core.domain.interactor

import app.ditsdev.core.domain.model.Game
import app.ditsdev.core.domain.repository.game.ImplGameRepository
import app.ditsdev.core.domain.usecase.GameUseCase
import app.ditsdev.core.data.result.resource.ResourceResult
import io.reactivex.rxjava3.core.Flowable

class GameInteractor(private val gameRepository: ImplGameRepository) : GameUseCase {
    override fun getAllGames(): Flowable<ResourceResult<List<Game>>> {
        return gameRepository.getAllGames()
    }

    override fun getFavoriteGames(): Flowable<List<Game>> {
        return gameRepository.getFavoriteGames()
    }

    override fun setFavoriteGames(game: Game, state: Boolean) {
        gameRepository.setFavoriteGames(game, state)
    }

    override fun searchGames(params: String): Flowable<List<Game>> {
        return gameRepository.searchGames(params)
    }
}