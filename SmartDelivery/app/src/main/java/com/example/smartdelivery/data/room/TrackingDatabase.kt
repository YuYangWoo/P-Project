
package com.example.smartdelivery.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [TrackingData::class], version = 1)
abstract class TrackingDatabase : RoomDatabase(){

    abstract fun trackingDao(): TrackingDao

    companion object{
        @Volatile
        private var instance: TrackingDatabase? = null
        fun getDatabase(context: Context): TrackingDatabase?{
            if(instance == null){
                synchronized(TrackingDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TrackingDatabase::class.java,
                        "tracking_data"
                    ).build()
                }
            }
            return instance
        }
    }
}