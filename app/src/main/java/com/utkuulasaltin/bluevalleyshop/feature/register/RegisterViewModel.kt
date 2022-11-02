package com.utkuulasaltin.bluevalleyshop.feature.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.utkuulasaltin.bluevalleyshop.data.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager,
    private val firebaseAuth: FirebaseAuth
): ViewModel() {

    private val _uiState = MutableStateFlow<RegisterUiState>(RegisterUiState.Empty)
    val uiState: StateFlow<RegisterUiState> = _uiState

    private val _uiEvent = MutableSharedFlow<RegisterViewEvent>(replay = 0)
    val uiEvent: SharedFlow<RegisterViewEvent> = _uiEvent

    fun register(userName: String, password: String, confirmPassword: String) {
        viewModelScope.launch {
            if (isValidFields(userName, password, confirmPassword)) {
                firebaseAuth.createUserWithEmailAndPassword(
                    "${userName}@bluevalley.com",
                    password
                ).addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        viewModelScope.launch {
                            _uiEvent.emit(RegisterViewEvent.NavigateToMain)
                        }

                    } else {
                        viewModelScope.launch {
                            _uiEvent.emit((RegisterViewEvent.ShowError(task.exception?.message.toString())))
                        }
                    }
                }
            } else {
                _uiEvent.emit(RegisterViewEvent.ShowError("Please fill all fields"))
            }
        }
    }

    private fun isValidFields(userName: String, password: String, confirmPassword: String): Boolean {
        return userName.isNotEmpty()
                && password.isNotEmpty()
                && confirmPassword.isNotEmpty()
                && password == confirmPassword
    }
}

sealed class RegisterViewEvent {
    object NavigateToMain: RegisterViewEvent()
    class ShowError(val error: String): RegisterViewEvent()
}

sealed class RegisterUiState {
    object Empty: RegisterUiState()
    object Loading: RegisterUiState()
    object Success: RegisterUiState()
    class Error(val error: String): RegisterUiState()
}