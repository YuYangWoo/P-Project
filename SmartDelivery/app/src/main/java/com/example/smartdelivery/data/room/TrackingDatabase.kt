
package com.example.smartdelivery.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(TrackingData::class), version = 1, exportSchema = false)
public abstract class TrackingDatabase : RoomDatabase() {
    abstract fun tracingDao(): TrackingDao


    companion object {
        @Volatile
        private var INSTANCE: TrackingDatabase ?= null

        fun getDatabase(context: Context): TrackingDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TrackingDatabase::class.java,
                    "tracking_data"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
