package com.example.homescreenlib.module

import com.example.homescreenlib.data.DashboardItems
import com.example.homescreenlib.domain.repository.DashboardRepository
import com.example.homescreenlib.domain.repository.DashboardRepositoryImpl
import com.example.homescreenlib.domain.usecase.GetDashboardItemsUseCase
import com.example.homescreenlib.viewmodel.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule: Module = module{
    single { DashboardItems() }
    single { DashboardRepositoryImpl(get()) } bind DashboardRepository::class
    factory { GetDashboardItemsUseCase(get()) }
    viewModel { DashboardViewModel(get()) }
}