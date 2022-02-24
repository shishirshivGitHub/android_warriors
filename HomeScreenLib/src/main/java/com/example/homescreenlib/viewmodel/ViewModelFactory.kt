/*
package com.example.homescreenlib.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.homescreenlib.data.DashboardItems

class ViewModelFactory(private val dashboardItems: DashboardItems) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            return DashboardViewModel(dashboardItems) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}*/
