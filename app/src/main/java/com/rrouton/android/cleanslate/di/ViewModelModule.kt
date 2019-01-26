package com.rrouton.android.cleanslate.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rrouton.android.cleanslate.viewModel.ClientViewModelFactory
import com.rrouton.android.cleanslate.ui.login.LoginViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindUserViewModel(userViewModel: LoginViewModel): ViewModel

    //Add new view model bindings above

    @Binds
    abstract fun bindViewModelFactory(factory: ClientViewModelFactory): ViewModelProvider.Factory
}