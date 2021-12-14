package com.example.smartdelivery.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TrackingData::class], version = 3)
abstract class TrackingDatabase : RoomDatabase(){
    abstract fun trackingDao(): TrackingDao
}