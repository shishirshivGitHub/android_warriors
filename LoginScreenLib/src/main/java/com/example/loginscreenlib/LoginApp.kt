package com.example.loginscreenlib

import android.app.Application
import com.example.loginscreenlib.common.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LoginApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LoginApp)
            modules(listOf(loginModule))
        }
    }
}