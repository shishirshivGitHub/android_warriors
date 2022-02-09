package com.example.homescreenlib.module

import com.example.homescreenlib.data.DashboardItems
import com.example.homescreenlib.viewmodel.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module{
    single { DashboardItems() }
    viewModel { DashboardViewModel(get()) }
}