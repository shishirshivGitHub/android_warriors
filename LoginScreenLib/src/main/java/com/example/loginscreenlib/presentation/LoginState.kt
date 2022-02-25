package com.example.loginscreenlib.presentation

import com.example.loginscreenlib.data.model.LoginResponse

data class LoginState(
    val data: LoginResponse? = null,
    val error: String = "",
    val isLoading: Boolean = false
)