package com.rrouton.android.cleanslate.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.schedule

class LoginViewModel @Inject constructor() : ViewModel() {

    private val _countResult: MutableLiveData<Int> = MutableLiveData()
    private var count: Int = 0

    //Exposed for data binding in the xml
    val countResult: LiveData<Int>
        get() = _countResult

    //Exposed for the fragment to observe
    fun countResult(): LiveData<Int> {
        return _countResult
    }

    fun startCountDown() {
        Timer("SettingUp", false).schedule(0, 1000) {
            _countResult.postValue(count)
            count++
        }
    }
}
