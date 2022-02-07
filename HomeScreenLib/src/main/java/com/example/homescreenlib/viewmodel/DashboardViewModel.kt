package com.example.homescreenlib.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homescreenlib.data.Dashboard
import com.example.homescreenlib.data.DashboardItems

class DashboardViewModel(private val dashboardItems: DashboardItems): ViewModel() {
    private val _itemsList = MutableLiveData<List<Dashboard>>()
    val itemsList: LiveData<List<Dashboard>>
            get() = _itemsList

    fun getDashboardItems() {
        //val dashboardItems = DashboardItems()
        val items = dashboardItems.dashBoardItems()
        _itemsList.value = items
    }

}