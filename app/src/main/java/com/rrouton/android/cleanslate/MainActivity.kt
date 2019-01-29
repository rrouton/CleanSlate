package com.rrouton.android.cleanslate

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Notes:
 *  - Navigation Architecture Component
 *      -Single Activity multiple fragments architecture
 *  - TODO: SafeArgs to pass between fragments
 *  - Dagger 2 DI to provide dependencies
 *  - MVVM
 *      -View models
 *      -Data binding
 *  - Kotlin synthetic binding
 */

class MainActivity : DaggerAppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun supportFragmentInjector() = fragmentInjector
}
