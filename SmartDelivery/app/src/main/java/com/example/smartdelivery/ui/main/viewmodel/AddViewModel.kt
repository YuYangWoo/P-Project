package com.example.smartdelivery.ui.main.viewmodel

import androidx.lifecycle.*
import com.example.smartdelivery.data.room.TrackingDao
import com.example.smartdelivery.data.room.TrackingData

class AddViewModel(private val trackingDao: TrackingDao) : ViewModel() {

   fun insertData(trackingData: TrackingData) {
       trackingDao.insert(trackingData)
   }
    fun getData(): LiveData<List<TrackingData>> = trackingDao.getAll()

}