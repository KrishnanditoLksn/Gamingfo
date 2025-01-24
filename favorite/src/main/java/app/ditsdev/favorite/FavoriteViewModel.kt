package app.ditsdev.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import app.ditsdev.core.domain.usecase.GameUseCase

class FavoriteViewModel(private val gameUseCase: GameUseCase) : ViewModel() {
    fun getAllFavoriteGames() = gameUseCase.getFavoriteGames().toLiveData()
}