package com.devmaksem.authlet.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
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
//                    Toast.makeText(context, R.string.string_empty_error, Toast.LENGTH_SHORT)
//                        .show()

                    Snackbar.make(container, R.string.string_empty_error, 5000).show()
                }
                passwordField.text.equals("dddd") -> {
                    Toast.makeText(context, R.string.login_auth_error, Toast.LENGTH_SHORT)
                        .show()
                }
                else -> {
                    androidx.navigation.Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_mainFragment)
                    //navigation.navigate(R.id.action_loginFragment_to_mainFragment)
                }
            }
        }
    }
}