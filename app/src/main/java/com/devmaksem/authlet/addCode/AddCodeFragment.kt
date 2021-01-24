package com.devmaksem.authlet.addCode

import android.os.Bundle
import android.view.View
import com.devmaksem.authlet.R
import com.devmaksem.authlet.base.BaseFragment
import com.devmaksem.authlet.ext.generateHash
import com.devmaksem.authlet.mainScreen.dummy.listCodes
import com.devmaksem.authlet.mainScreen.item.ListItem
import com.devmaksem.authlet.ext.updateCall
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.add_code_fragment.*
import kotlinx.android.synthetic.main.fragment_main.*

class AddCodeFragment: BaseFragment(R.layout.add_code_fragment) {

    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var errorMessage = ""

        addCodeButton?.setOnClickListener {
            if (serviceName.text.isEmpty() || valueSecret.text.isEmpty()) {
                Snackbar.make(it, R.string.field_empty_error, 1000)
                errorMessage += R.string.field_empty_error
            }
            if (valueSecret.text.length < 16) {
                Snackbar.make(it, R.string.secret_too_short_error, 1500)
            }
            if (valueSecret.text.length >= 16 &&
                serviceName.text.isNotEmpty() &&
                valueSecret.text.isNotEmpty()
            ) {
                val hash: String = generateHash(valueSecret.text.toString())
                val item = ListItem(serviceName.text.toString(), hash)

                listCodes.add(item)

                serviceName.text = null
                valueSecret.text = null

                androidx.navigation.Navigation.findNavController(it).navigate(R.id.action_addCodeFragment_to_mainFragment)

            }
        }
    }
}