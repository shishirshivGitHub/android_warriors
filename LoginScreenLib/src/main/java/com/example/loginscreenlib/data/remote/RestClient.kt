package com.example.loginscreenlib.data.remote

import com.example.loginscreenlib.common.constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestClient {

    fun getRestClient(): Api {
        return Retrofit.Builder().baseUrl(constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Api::class.java)
    }
}