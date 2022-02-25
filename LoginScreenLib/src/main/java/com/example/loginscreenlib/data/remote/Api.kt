package com.example.loginscreenlib.data.remote

import com.example.loginscreenlib.data.model.LoginRequest
import com.example.loginscreenlib.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface Api {
    @POST("login")
    suspend fun loginApi(@Body loginRequest: LoginRequest) : LoginResponse
}