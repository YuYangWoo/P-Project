package com.example.smartdelivery.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackingDao{

    @Query("SELECT * from tracking_data")
    fun getAll(): Flow<List<TrackingData>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(trackingData: TrackingData)

}