package com.example.smartdelivery.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.smartdelivery.data.repository.LocalRepository
import com.example.smartdelivery.data.room.TrackingDao
import com.example.smartdelivery.data.room.TrackingData

class AddViewModel(private val trackingDao: TrackingDao, private val localRepository: LocalRepository) : ViewModel() {

    val deliveryList: LiveData<List<TrackingData>> = localRepository.trackingData.asLiveData()

    fun insertData(trackingData: TrackingData) {
        trackingDao.insert(trackingData)
    }

    fun deleteData(trackingData: TrackingData) {
        trackingDao.delete(trackingData)
    }

}