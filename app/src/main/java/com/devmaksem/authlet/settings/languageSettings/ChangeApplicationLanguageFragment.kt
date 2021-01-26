package com.devmaksem.authlet.settings.languageSettings

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import com.devmaksem.authlet.R
import com.devmaksem.authlet.app.SAVED_LANGUAGE
import com.devmaksem.authlet.base.BaseFragment
import com.devmaksem.authlet.settings.languageSettings.Languages.*
import kotlinx.android.synthetic.main.fragment_change_application_language.*
import java.util.*

class ChangeApplicationLanguageFragment :
    BaseFragment(R.layout.fragment_change_application_language) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = activity?.getPreferences(Context.MODE_PRIVATE)

        when (sharedPreferences?.getString(SAVED_LANGUAGE, RUSSIAN.name)) {
            ENGLISH.name -> {
                switch_to_eng.isChecked = true
            }
            UKRAINIAN.name -> {
                switch_to_ukr.isChecked = true
            }
            RUSSIAN.name -> {
                switch_to_rus.isChecked = true
            }
        }

        switch_to_eng.setOnClickListener {
            //setLanguage(ENGLISH.language)
            with(sharedPreferences?.edit()) {
                this?.putString(SAVED_LANGUAGE, ENGLISH.name)
                this?.apply()
            }
        }
        switch_to_ukr.setOnClickListener {
            setLanguage(UKRAINIAN.language)
            with(sharedPreferences?.edit()) {
                this?.putString(SAVED_LANGUAGE, UKRAINIAN.name)
                this?.apply()
            }
        }
        switch_to_rus.setOnClickListener {
            setLanguage(RUSSIAN.language)
            with(sharedPreferences?.edit()) {
                this?.putString(SAVED_LANGUAGE, RUSSIAN.name)
                this?.apply()
            }
        }

    }

    private fun setLanguage(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        requireContext().createConfigurationContext(config)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

}