package com.youarelaunched.challenge.presentation.di

import com.youarelaunched.challenge.presentation.vendors.viewmodel.VendorsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationDiModule {
    val koinModule = module {
        viewModel {
            VendorsViewModel(
                networkDataProvider = get()
            )
        }
    }
}