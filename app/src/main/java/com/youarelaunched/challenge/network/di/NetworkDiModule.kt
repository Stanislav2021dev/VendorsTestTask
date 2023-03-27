package com.youarelaunched.challenge.network.di

import com.youarelaunched.challenge.network.api.NetworkDataProvider
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object NetworkDiModule {
    val koinModule = module {

        factory {
            NetworkDataProvider(
                appContext = get(),
                workDispatcher = get()
            )
        }

        single {
            androidContext().resources
        }

        single {
            Dispatchers.IO
        }
    }
}