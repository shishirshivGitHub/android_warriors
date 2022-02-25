package com.example.loginscreenlib.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginscreenlib.common.Resource
import com.example.loginscreenlib.data.model.LoginRequest
import com.example.loginscreenlib.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class LoginViewModel(val loginUseCase: LoginUseCase) : ViewModel() {

    private var _loginResponse = MutableStateFlow(LoginState())
    val loginResponse: StateFlow<LoginState>
        get() = _loginResponse

    fun login(username: String, paswd: Int) {
        Log.i("Hello","Hello")
        val loginRequest = LoginRequest(username, paswd)

        loginUseCase(loginRequest).onEach {
            when (it) {
                is Resource.Loading -> {
                    _loginResponse.value = LoginState(isLoading = true)
                }
                is Resource.Error -> {
                    _loginResponse.value = LoginState(error = it.message ?: "")
                }
                is Resource.Success -> {
                    _loginResponse.value = LoginState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}