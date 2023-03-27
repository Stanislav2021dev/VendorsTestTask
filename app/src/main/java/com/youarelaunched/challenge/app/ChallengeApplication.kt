package com.youarelaunched.challenge.app

import android.app.Application
import com.youarelaunched.challenge.network.di.NetworkDiModule
import com.youarelaunched.challenge.presentation.di.PresentationDiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ChallengeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initDi()
    }

    private fun initDi() {
        startKoin {
            androidLogger()
            androidContext(this@ChallengeApplication)
            modules(
                modules = NetworkDiModule.koinModule + PresentationDiModule.koinModule
            )
        }
    }
}