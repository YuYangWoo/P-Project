package com.example.smartdelivery.data.repository

import com.example.smartdelivery.data.room.TrackingDao
import com.example.smartdelivery.data.room.TrackingData

class LocalRespository(private val trackingDao: TrackingDao) {
    val trackingList = trackingDao.getList()

    suspend fun insert(trackingData: TrackingData) {
        trackingDao.insert(trackingData)
    }

}