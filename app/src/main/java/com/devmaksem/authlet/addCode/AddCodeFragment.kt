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

class AddCodeFragment: BaseFragment(R.layout.add_code_fragment) {

    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var errorMessage = ""

        addCodeButton?.setOnClickListener {
            if (serviceName.text.isEmpty() || valueSecret.text.isEmpty()) {
                errorMessage += R.string.field_empty_error
            }
            if (valueSecret.text.length < 16) {
                errorMessage += R.string.secret_too_short_error
            }
            if (errorMessage.isNotEmpty()) {
                Snackbar.make(it, errorMessage, 7000)
            }

            if (valueSecret.text.length >= 16 &&
                serviceName.text.isNotEmpty() &&
                valueSecret.text.isNotEmpty()
            ) {
                val hash: String = generateHash(valueSecret.text.toString())
                val item = ListItem(serviceName.text.toString(), hash)

                listCodes.add(item)
                updateCall = true

                serviceName.text = null
                valueSecret.text = null

                Snackbar.make(it, R.string.done_message, 1000)
                Thread.sleep(200)
                androidx.navigation.Navigation.findNavController(it).navigate(R.id.action_addCodeFragment_to_mainFragment)
            }
        }
    }
}