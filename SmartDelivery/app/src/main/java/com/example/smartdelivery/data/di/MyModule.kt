package com.example.smartdelivery.data.di

import android.app.Application
import androidx.room.Room
import com.example.smartdelivery.data.repository.LocalRepository
import com.example.smartdelivery.data.repository.RemoteRepository
import com.example.smartdelivery.data.room.TrackingDao
import com.example.smartdelivery.data.room.TrackingDatabase
import com.example.smartdelivery.ui.main.viewmodel.*
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MyModule = module {
    single { RemoteRepository() }
    viewModel { MainViewModel(get()) }
    viewModel { AddViewModel(get(), get()) }
    viewModel {LoginViewModel(get())}
    viewModel {SignupViewModel(get())}
    single { LocalRepository(get()) }
    viewModel { PackagesViewModel(get()) }
    viewModel { PackageDetailViewModel(get())}
    viewModel { LossViewModel(get()) }
}

val dbModule = module {
    fun provideDatabase(application: Application): TrackingDatabase {
        return Room.databaseBuilder(application, TrackingDatabase::class.java,"tracking_data")
            .fallbackToDestructiveMigration().build()
    }

    fun provideDao(dataBase: TrackingDatabase): TrackingDao {
        return dataBase.trackingDao()
    }
    single {provideDatabase(androidApplication())}
    single {provideDao(get())}
}



