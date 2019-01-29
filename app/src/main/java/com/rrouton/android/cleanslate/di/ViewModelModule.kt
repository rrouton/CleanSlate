package com.rrouton.android.cleanslate.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rrouton.android.cleanslate.viewModel.DaggerViewModelFactory
import com.rrouton.android.cleanslate.ui.countdown.CountdownViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CountdownViewModel::class)
    abstract fun bindCountdownViewModel(countdownViewModel: CountdownViewModel): ViewModel

    //Add new view model bindings above

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}