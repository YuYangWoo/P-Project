package com.example.smartdelivery.data.di

import android.app.Application
import com.example.smartdelivery.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

open class MyApplication: Application() {

    companion object{
        lateinit var instance: MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) org.koin.core.logger.Level.ERROR else org.koin.core.logger.Level.NONE)
            androidContext(this@MyApplication)
            modules(listOf(MyModule, dbModule))
        }
        instance = this
    }
}