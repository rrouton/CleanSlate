package com.rrouton.android.cleanslate.di

import com.rrouton.android.cleanslate.ui.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

}