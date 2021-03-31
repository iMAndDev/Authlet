package com.devmaksem.authlet.app

import com.devmaksem.authlet.addCode.addCodeFragmentDi
import com.devmaksem.authlet.login.loginFragmentDi
import com.devmaksem.authlet.mainScreen.mainFragmentDi
import com.devmaksem.authlet.settings.settingsFragmentDi

val appDi = mainFragmentDi + loginFragmentDi + addCodeFragmentDi + settingsFragmentDi