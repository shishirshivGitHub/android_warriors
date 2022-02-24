package com.example.homescreenlib.data

import android.content.res.Resources
import com.example.homescreenlib.R

class DashboardItems{
     fun dashBoardItems() : List<Dashboard>{
        return listOf(
            Dashboard(
                title = "Walking",
                image = R.drawable.ic_directions_walk
            ),
            Dashboard(
                title = "Treadmill",
                image = R.drawable.thradmill
            ),
            Dashboard(
                title = "Running",
                image = R.drawable.ic_directions_run
            ),
            Dashboard(
                title = "Cycling",
                image = R.drawable.ic_directions_bike
            ),
            Dashboard(
                title = "Gym",
                image = R.drawable.ic_dumbbell
            ),
            Dashboard(
                title = "Yoga",
                image = R.drawable.yoga
            ),
        )
    }
}
