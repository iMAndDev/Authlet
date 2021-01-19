package com.devmaksem.authlet

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devmaksem.authlet.app.DARK_THEME
import com.devmaksem.authlet.app.SAVED_LANGUAGE
import com.devmaksem.authlet.app.SAVED_THEME
import com.devmaksem.authlet.app.WHITE_THEME
import com.devmaksem.authlet.settings.languageSettings.Languages
import java.util.*

class ActivityContainer : AppCompatActivity(R.layout.activity_container) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)
        when (sharedPreferences.getString(SAVED_LANGUAGE, Languages.RUSSIAN.name)) {
            Languages.ENGLISH.name -> {
                setLanguage(Languages.ENGLISH.language)
            }
            Languages.UKRAINIAN.name -> {
                setLanguage(Languages.UKRAINIAN.language)
            }
            Languages.RUSSIAN.name -> {
                setLanguage(Languages.RUSSIAN.language)
            }
        }
        when (sharedPreferences.getString(SAVED_THEME, WHITE_THEME)) {
            WHITE_THEME -> {
                setTheme(R.style.AppTheme)
            }
            DARK_THEME -> {
                setTheme(R.style.DarkTheme)
            }
        }
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