package com.rrouton.android.cleanslate.di

import com.rrouton.android.cleanslate.ui.countdown.CountdownFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    internal abstract fun contributeCountdownFragment(): CountdownFragment

}