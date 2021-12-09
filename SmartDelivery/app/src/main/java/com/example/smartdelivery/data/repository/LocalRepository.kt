package com.example.smartdelivery.data.repository

import com.example.smartdelivery.data.room.TrackingDao

class LocalRepository(private val trackingDao: TrackingDao) {
    val trackingData = trackingDao.getAll()
}