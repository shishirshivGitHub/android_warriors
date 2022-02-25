package com.example.loginscreenlib.domain.repository

import com.example.loginscreenlib.data.model.LoginRequest
import com.example.loginscreenlib.data.model.LoginResponse
import com.example.loginscreenlib.data.remote.RestClient

interface LoginRepository {
    suspend fun LoginApiCall(loginRequest: LoginRequest) : LoginResponse
}