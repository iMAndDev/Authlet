package com.devmaksem.authlet.app

import android.app.Application
import android.content.res.Configuration
import java.util.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()
//        when (sharedPreferences.getString(SAVED_LANGUAGE, Languages.RUSSIAN.name)) {
//            Languages.ENGLISH.name -> {
//                setLanguage(Languages.ENGLISH.language)
//            }
//            Languages.UKRAINIAN.name -> {
//                setLanguage(Languages.UKRAINIAN.language)
//            }
//            Languages.RUSSIAN.name -> {
//                setLanguage(Languages.RUSSIAN.language)
//            }
//        }
    }

    private fun setLanguage(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        this.createConfigurationContext(config)
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}