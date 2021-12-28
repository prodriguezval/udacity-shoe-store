package com.udacity.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel: ViewModel() {
    private var _isOnboarded = MutableLiveData<Boolean>()
    val isOnboarded: LiveData<Boolean>
        get() = _isOnboarded
    private var _isLogged = MutableLiveData<Boolean>()
    val isLogged: LiveData<Boolean>
        get() = _isLogged


    init {
        _isLogged.value = false
        _isOnboarded.value = false
    }

    fun onLogin() {
        Timber.i("user login is finished")
        _isLogged.value = true
    }

    fun onOnboardingFinished() {
        Timber.i("user onboarding is finished")
        _isOnboarded.value = true
    }
}