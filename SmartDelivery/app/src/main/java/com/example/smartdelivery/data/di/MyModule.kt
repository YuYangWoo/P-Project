package com.example.smartdelivery.data.di

import com.example.smartdelivery.data.repository.LocalRepository
import com.example.smartdelivery.data.repository.RemoteRepository
import com.example.smartdelivery.data.room.TrackingDatabase
import com.example.smartdelivery.ui.main.viewmodel.AddViewModel
import com.example.smartdelivery.ui.main.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MyModule = module {
    single { RemoteRepository() }
    viewModel { MainViewModel(get()) }
}

val dbModule = module {
    val applicationScope = CoroutineScope(SupervisorJob())
    single {
        TrackingDatabase.getDatabase(androidApplication())
    }
    single {
        get<TrackingDatabase>().trackingDao()
    }
    single { LocalRepository(get()) }
    viewModel { AddViewModel(get()) }
}



