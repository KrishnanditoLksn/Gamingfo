package app.ditsdev.search.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import app.ditsdev.core.domain.usecase.GameUseCase

class SearchViewModel(private val gameUseCase: GameUseCase) : ViewModel() {
    fun searchGame(params: String) = gameUseCase.searchGames(params).toLiveData()
}