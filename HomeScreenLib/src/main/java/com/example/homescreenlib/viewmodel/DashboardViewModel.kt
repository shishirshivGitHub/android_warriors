package com.example.homescreenlib.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homescreenlib.data.Dashboard
import com.example.homescreenlib.data.DashboardItems
import com.example.homescreenlib.domain.usecase.GetDashboardItemsUseCase
import com.example.homescreenlib.utils.Event

class DashboardViewModel(private val dashboardItemsUseCase: GetDashboardItemsUseCase) : ViewModel() {
    private val _itemsList = MutableLiveData<Event<List<Dashboard>>>()
    val itemsList: LiveData<Event<List<Dashboard>>>
        get() = _itemsList

    fun getDashboardItems() {
        val items = dashboardItemsUseCase.invoke()
        _itemsList.value = Event(items)
    }

}