package com.example.loginscreenlib.data.repositoryImpl

import com.example.loginscreenlib.data.model.LoginRequest
import com.example.loginscreenlib.data.model.LoginResponse
import com.example.loginscreenlib.data.remote.RestClient
import com.example.loginscreenlib.domain.repository.LoginRepository

class LoginRepositoryImpl(private val restClient: RestClient) : LoginRepository {

    override suspend fun LoginApiCall(loginRequest: LoginRequest): LoginResponse {
        return restClient.getRestClient().loginApi(loginRequest)
    }
}