package com.rrouton.android.cleanslate.di

import androidx.lifecycle.ViewModelProvider
import com.rrouton.android.cleanslate.viewModel.ClientViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ClientViewModelFactory): ViewModelProvider.Factory
}