package app.ditsdev.gamingfo.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import app.ditsdev.core.domain.usecase.GameUseCase
import app.ditsdev.core.domain.usecase.PublisherUseCase

class HomeViewModel(
    private val gameUseCase: GameUseCase,
    private val publisherUseCase: PublisherUseCase
) : ViewModel() {
    fun getAllGames() = gameUseCase.getAllGames().toLiveData()
    fun getAllPublishers() = publisherUseCase.displayAllPublishers().toLiveData()
}