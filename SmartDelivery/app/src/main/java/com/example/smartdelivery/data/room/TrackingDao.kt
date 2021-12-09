package com.example.smartdelivery.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackingDao{

    @Query("SELECT * FROM tracking_data")
    fun getAll(): LiveData<List<TrackingData>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(trackingData: TrackingData)

}