package com.example.loginscreenlib.common

import com.example.loginscreenlib.data.model.LoginRequest
import com.example.loginscreenlib.data.remote.RestClient
import com.example.loginscreenlib.data.repositoryImpl.LoginRepositoryImpl
import com.example.loginscreenlib.domain.repository.LoginRepository
import com.example.loginscreenlib.domain.usecase.LoginUseCase
import com.example.loginscreenlib.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

val loginModule: Module = module {
    single { RestClient() }
    single { LoginRepositoryImpl(get()) } bind LoginRepository::class
    factory { LoginUseCase(get()) }
    viewModel { LoginViewModel(get()) }
}