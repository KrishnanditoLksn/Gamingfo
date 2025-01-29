package app.ditsdev.favorite.core.di


import app.ditsdev.favorite.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object FavoriteModule {
    val favoriteFeatureModule = module {
        viewModel { FavoriteViewModel(get()) }
    }
}