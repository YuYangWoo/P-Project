package com.example.smartdelivery.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.smartdelivery.data.model.request.TrackingData
//import com.example.smartdelivery.data.model.request.TrackingData
import com.example.smartdelivery.data.repository.RemoteRepository
import com.example.smartdelivery.util.Resource
import java.lang.Exception

class MainViewModel(private val remoteRepository: RemoteRepository) : ViewModel() {

    fun insertData(trackingData: TrackingData) = liveData{
        emit(Resource.loading(null))
        try {
            emit(Resource.success(remoteRepository.requestTracking(trackingData.trackingNum, trackingData.company_code)))
        } catch (e: Exception) {
            emit(Resource.error(null, e.message ?: "Error"))
        }
    }

    fun requestCompany() = liveData {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(remoteRepository.requestCompany()))
            Log.d("viewmodel", "requestCompany:${remoteRepository.requestCompany()} ")
        } catch (e: Exception) {
            emit(Resource.error(null, e.message ?: "Error"))
            Log.d("viewmodel", "requestCompany:${e.message} ")
        }
    }

}