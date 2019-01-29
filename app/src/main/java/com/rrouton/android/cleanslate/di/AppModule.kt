package com.rrouton.android.cleanslate.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.rrouton.android.cleanslate.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideHandheldScannerApplication(
        application: Application
    ): MyApplication {
        return application as MyApplication
    }

    /**
     * Example of another app level dependency, but not used now fyi
     */
    @Provides
    @Singleton
    fun providePreferences(
        application: Application
    ): SharedPreferences {
        return application.getSharedPreferences(
            "store", Context.MODE_PRIVATE
        )
    }
}