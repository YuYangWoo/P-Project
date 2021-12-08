package com.example.smartdelivery.data.di

import com.example.smartdelivery.data.repository.RemoteRepository
import com.example.smartdelivery.ui.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val MyModule = module {
    single { RemoteRepository() }
    viewModel { MainViewModel(get()) }
}