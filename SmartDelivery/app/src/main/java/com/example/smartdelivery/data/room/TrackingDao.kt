package com.example.smartdelivery.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackingDao {
    @Query("SELECT * FROM tracking_data")
    fun getList(): Flow<List<TrackingData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(trackingData: TrackingData)

    @Query("DELETE FROM tracking_data")
    suspend fun deleteAll()
}