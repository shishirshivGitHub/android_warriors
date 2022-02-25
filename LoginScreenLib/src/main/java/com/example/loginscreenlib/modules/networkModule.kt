package com.example.loginscreenlib.modules

import com.example.loginscreenlib.common.constants
import com.example.loginscreenlib.data.remote.Api
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule: Module = module {
    // Provide Gson
    single<Gson> {
        GsonBuilder().create()
    }

    // Provide Retrofit
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    // Provide Api
    single {
        get<Retrofit>().create(Api::class.java)
    }
}