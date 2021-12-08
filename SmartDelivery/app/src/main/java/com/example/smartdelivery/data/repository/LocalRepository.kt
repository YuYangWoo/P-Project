package com.example.smartdelivery.data.repository

import android.app.Application
import com.example.smartdelivery.data.room.TrackingDao
import com.example.smartdelivery.data.room.TrackingData
import com.example.smartdelivery.data.room.TrackingDatabase
import kotlinx.coroutines.flow.Flow

class LocalRepository(private val trackingDao: TrackingDao) {
    val allList = trackingDao.getAll()
    suspend fun insertData(trackingData: TrackingData){
        trackingDao.insertData(trackingData)
    }

}