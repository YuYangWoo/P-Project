package com.example.smartdelivery.data.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackingDao{

    @Query("SELECT * FROM tracking_data")
    fun getAll(): Flow<List<TrackingData>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(trackingData: TrackingData)

    @Delete
    fun delete(trackingData: TrackingData)

}