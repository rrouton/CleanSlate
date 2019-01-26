package com.rrouton.android.cleanslate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}
