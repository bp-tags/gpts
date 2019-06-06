package com.discordtime.gpts

import android.app.Application
import com.discordtime.gpts.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { androidContext(this@Application)
            modules(viewModelModule)
        }

    }
}