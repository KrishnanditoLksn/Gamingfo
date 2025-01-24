package app.ditsdev.gamingfo.di


import app.ditsdev.gamingfo.ui.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object FavoriteModule {
    val favoriteViewModel = module {
        viewModel { FavoriteViewModel(get()) }
    }
}