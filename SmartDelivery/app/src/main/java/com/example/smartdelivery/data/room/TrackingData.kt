package com.example.smartdelivery.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.smartdelivery.data.model.response.TrackingDetail

@Entity(tableName = "tracking_data")
data class TrackingData(
    @PrimaryKey
    @ColumnInfo(name = "trackingNum")
    val trackingNum: String,
    @ColumnInfo(name = "company")
    val company: String?,
    @ColumnInfo(name = "company_code")
    val company_code: String?,
    @ColumnInfo(name = "itemName")
    var itemName: String?,
    @ColumnInfo(name = "complete")
    val complete: Boolean?
)