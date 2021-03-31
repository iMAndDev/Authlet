package com.devmaksem.authlet.app

import android.app.Application
import com.devmaksem.authlet.app.appDi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

const val SAVED_LANGUAGE = "saved_language"
const val SAVED_THEME = "saved_theme"
const val DARK_THEME = "dark_theme"
const val WHITE_THEME = "white_theme"

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appDi)
        }
    }
}