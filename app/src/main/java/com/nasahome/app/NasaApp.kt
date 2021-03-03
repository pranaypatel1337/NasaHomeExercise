package com.nasahome.app

import android.app.Application
import com.nasahome.app.di.mainModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class NasaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(mainModules)
        }
    }
}