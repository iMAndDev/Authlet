package com.devmaksem.authlet.login

import android.os.Bundle
import android.view.View
import com.devmaksem.authlet.R
import com.devmaksem.authlet.base.BaseFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*

class LoginActivity : BaseFragment(R.layout.fragment_login) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginButton?.setOnClickListener {
            when {
                passwordField.text.isEmpty() -> {
                    Snackbar.make(container, R.string.string_empty_error, 5000).show()
                }
                passwordField.text.toString() == "0000" -> {
                    androidx.navigation.Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_mainFragment)
                }
                else -> {
                    Snackbar.make(container, R.string.login_auth_error, 5000)
                        .show()
                }
            }
        }
    }
}