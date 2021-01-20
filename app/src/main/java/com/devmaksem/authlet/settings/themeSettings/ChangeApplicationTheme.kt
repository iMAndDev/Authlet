package com.devmaksem.authlet.settings.themeSettings

import android.content.Context
import android.os.Bundle
import android.view.View
import com.devmaksem.authlet.R
import com.devmaksem.authlet.app.DARK_THEME
import com.devmaksem.authlet.app.SAVED_THEME
import com.devmaksem.authlet.app.WHITE_THEME
import com.devmaksem.authlet.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_change_application_theme.*

class ChangeApplicationTheme : BaseFragment(R.layout.fragment_change_application_theme) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = activity?.getPreferences(Context.MODE_PRIVATE)

        when (sharedPreferences?.getString(SAVED_THEME, WHITE_THEME)) {
            WHITE_THEME -> {
                white_theme_button.isChecked = true
            }
            DARK_THEME -> {
                black_theme_button.isChecked = true
            }
        }

        white_theme_button.setOnClickListener {
            activity?.setTheme(R.style.AppTheme)
            with(sharedPreferences?.edit()) {
                this?.putString(SAVED_THEME, WHITE_THEME)
                this?.apply()
            }
        }

        black_theme_button.setOnClickListener {
            activity?.setTheme(R.style.DarkTheme)
            with(sharedPreferences?.edit()) {
                this?.putString(SAVED_THEME, DARK_THEME)
                this?.apply()
            }
        }
    }

}