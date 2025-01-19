package app.ditsdev.core.domain.interactor

import app.ditsdev.core.domain.model.Game
import app.ditsdev.core.domain.repository.GameRepository
import app.ditsdev.core.domain.usecase.GameUseCase
import app.ditsdev.core.result.resource.ResourceResult
import io.reactivex.rxjava3.core.Flowable

class GameInteractor(private val gameRepository: GameRepository) : GameUseCase {
    override fun getAllTourism(): Flowable<ResourceResult<List<Game>>> {
        return gameRepository.getAllGames()
    }

    override fun getFavoriteGames(): Flowable<List<Game>> {
        return gameRepository.getFavoriteGames()
    }

    override fun setFavoriteGames(game: Game, state: Boolean) {
        gameRepository.setFavoriteGames(game, state)
    }
}