package com.devmaksem.authlet.mainScreen

import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainFragmentDi = module {
    module {
        fragment { MainFragment() }
    }

    viewModel { MainViewModel() }
    //TODO: initialize all modules
}