package com.stepikcourses

import android.app.Application
import com.stepikcourses.di.appModule
import com.stepikcourses.di.dataModule
import com.stepikcourses.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}