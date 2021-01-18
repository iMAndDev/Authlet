package com.devmaksem.authlet.settings

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.devmaksem.authlet.R
import com.devmaksem.authlet.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_preferences.*

class SettingsFragment : BaseFragment(R.layout.fragment_preferences) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        language.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_changeLanguageFragment)
        }
    }

}