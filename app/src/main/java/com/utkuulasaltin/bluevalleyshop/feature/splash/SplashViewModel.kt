package com.utkuulasaltin.bluevalleyshop.feature.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utkuulasaltin.bluevalleyshop.data.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val dataStoreManager: DataStoreManager):
    ViewModel() {

    private val _uiEvent = MutableSharedFlow<SplashViewEvent>(replay = 0)
    val uiEvent: SharedFlow<SplashViewEvent> = _uiEvent

    //TODO
    // Check Login User
    // Navigate to main activity if user is logged in
    // Navigate to login activity if user isn't logged in

    init {
        checkOnBoardingVisibleStatus()
    }

    private fun checkOnBoardingVisibleStatus() {
        viewModelScope.launch {
            dataStoreManager.getOnBoardingVisible.collectLatest {
                if (it) {
                    _uiEvent.emit(SplashViewEvent.NavigateToMain)
                    //Navigate to main activity
                } else {
                    _uiEvent.emit(SplashViewEvent.NavigateToOnBoarding)
                    //Navigate to onboarding activity
                }
            }
        }
    }
}

sealed class SplashViewEvent {
    object NavigateToLogin: SplashViewEvent()
    object NavigateToMain: SplashViewEvent()
    object NavigateToOnBoarding: SplashViewEvent()
}