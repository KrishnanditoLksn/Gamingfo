package app.ditsdev.gamingfo.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import app.ditsdev.core.domain.usecase.GameUseCase

class HomeViewModel(private val gameUseCase: GameUseCase) : ViewModel() {
    fun getAllGames() = gameUseCase.getAllGames().toLiveData()
}