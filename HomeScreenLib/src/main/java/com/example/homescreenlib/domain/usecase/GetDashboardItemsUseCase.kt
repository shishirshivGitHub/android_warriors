package com.example.homescreenlib.domain.usecase
import com.example.homescreenlib.data.Dashboard
import com.example.homescreenlib.domain.repository.DashboardRepositoryImpl


class GetDashboardItemsUseCase(private val repository: DashboardRepositoryImpl) {
    operator fun invoke() : List<Dashboard>{
        return repository.getDashboardItems().dashBoardItems()

    }
}