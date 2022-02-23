package com.example.homescreenlib.domain.repository

import com.example.homescreenlib.data.Dashboard
import com.example.homescreenlib.data.DashboardItems

class DashboardRepositoryImpl(private val dashboard: DashboardItems) : DashboardRepository {
    override fun getDashboardItems(): DashboardItems {
        return dashboard
    }
}