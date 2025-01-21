package app.ditsdev.gamingfo.ui.detail

import androidx.lifecycle.ViewModel
import app.ditsdev.core.domain.model.Game
import app.ditsdev.core.domain.usecase.GameUseCase

class DetailGameViewModel(private val gameUseCase: GameUseCase) : ViewModel() {
    fun setFavoriteGames(game: Game, newState: Boolean) =
        gameUseCase.setFavoriteGames(game, newState)
}