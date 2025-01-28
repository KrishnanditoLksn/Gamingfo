package app.ditsdev.search.di

import app.ditsdev.search.presentation.viewmodels.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object SearchModule {
    val searchFeatureModule = module {
        viewModel { SearchViewModel(get()) }
    }
}