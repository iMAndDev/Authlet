package com.devmaksem.authlet.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.devmaksem.authlet.R
import com.devmaksem.authlet.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginActivity : BaseFragment(R.layout.fragment_login) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginButton?.setOnClickListener {
            if (passwordField.text.isEmpty()) {
                Toast.makeText(context, R.string.string_empty_error, Toast.LENGTH_SHORT)
                    .show()
            }
            else if (passwordField.text.equals("dddd")) {
                Toast.makeText(context, R.string.login_auth_error, Toast.LENGTH_SHORT)
                    .show()
            }
            else {
                androidx.navigation.Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_mainFragment)
                //navigation.navigate(R.id.action_loginFragment_to_mainFragment)
            }
        }
    }
}