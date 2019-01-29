package com.rrouton.android.cleanslate

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.rrouton.android.cleanslate.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject

class MyApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        DaggerAppComponent.builder().application(this)
            .build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}
