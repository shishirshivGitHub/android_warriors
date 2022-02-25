package com.example.loginscreenlib.domain.usecase

import android.util.Log
import com.example.loginscreenlib.common.Resource
import com.example.loginscreenlib.data.model.LoginRequest
import com.example.loginscreenlib.data.model.LoginResponse
import com.example.loginscreenlib.data.repositoryImpl.LoginRepositoryImpl
import com.example.loginscreenlib.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import retrofit2.HttpException
import java.io.IOException

class LoginUseCase(val loginRepositoryImpl: LoginRepositoryImpl){


    operator fun invoke(loginRequest: LoginRequest): Flow<Resource<LoginResponse>> = flow {
        Log.i("Hello","Hello2")
        try {
            emit(Resource.Loading())

            val loginResponse = loginRepositoryImpl.LoginApiCall(loginRequest)

            emit(Resource.Success(data = loginResponse))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown Error"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Your Internet Connection"))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown Error"))
        }
    }
}