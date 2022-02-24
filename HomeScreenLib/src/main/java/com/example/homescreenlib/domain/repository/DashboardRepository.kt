package com.example.homescreenlib.domain.repository

import com.example.homescreenlib.data.Dashboard
import com.example.homescreenlib.data.DashboardItems

interface DashboardRepository {
    fun getDashboardItems() : DashboardItems
}