package com.example.smartdelivery.data.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.smartdelivery.data.repository.LocalRespository
import com.example.smartdelivery.data.repository.RemoteRepository
import com.example.smartdelivery.data.room.TrackingData
import com.example.smartdelivery.data.room.TrackingDatabase
import com.example.smartdelivery.ui.main.viewmodel.AddViewModel
import com.example.smartdelivery.ui.main.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MyModule = module {
    single { RemoteRepository() }
    viewModel { MainViewModel(get()) }
    single { LocalRespository(get()) }
    viewModel { AddViewModel(get()) }
}

val dbModule = module {
    single {
        TrackingDatabase.getDatabase(androidApplication())
    }
    single {
        get<TrackingDatabase>().tracingDao()
    }
}



