package com.rrouton.android.cleanslate

import com.rrouton.android.cleanslate.di.DaggerAppComponent
import dagger.android.support.DaggerApplication

class MyApplication : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder()
        .application(this)
        .build()
}