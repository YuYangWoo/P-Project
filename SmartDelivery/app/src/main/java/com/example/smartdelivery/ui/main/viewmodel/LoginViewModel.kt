package com.example.smartdelivery.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.smartdelivery.data.model.request.LoginRequest
import com.example.smartdelivery.data.repository.RemoteRepository
import com.example.smartdelivery.util.Resource

class LoginViewModel(private val remoteRepository: RemoteRepository) : ViewModel() {

    fun loginApiCall(loginRequest: LoginRequest) = liveData {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(remoteRepository.requestLogin(loginRequest)))
        } catch (e: Exception) {
            emit(Resource.error(null, e.message ?: "Error Occurred!"))
        }
    }

}