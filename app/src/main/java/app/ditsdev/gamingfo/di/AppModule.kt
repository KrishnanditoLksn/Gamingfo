package app.ditsdev.gamingfo.di

import app.ditsdev.gamingfo.ui.detail.DetailGameViewModel
import app.ditsdev.gamingfo.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {
    val viewModelModule = module {
        viewModel { HomeViewModel(get()) }
        viewModel { DetailGameViewModel(get()) }
    }
}