package com.example.homescreenlib.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.homescreenlib.data.Dashboard

class BindingUtils {
    companion object{
        @JvmStatic
        @BindingAdapter("dashboardImage")
        fun ImageView.setDashboardImage(item: Dashboard){
            setImageResource(item.image)
        }
    }
}