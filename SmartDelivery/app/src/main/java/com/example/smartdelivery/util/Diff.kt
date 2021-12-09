package com.example.smartdelivery.util

import androidx.recyclerview.widget.DiffUtil
import com.example.smartdelivery.data.room.TrackingData

object Diff : DiffUtil.ItemCallback<TrackingData>() {
    override fun areItemsTheSame(oldItem: TrackingData, newItem: TrackingData): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: TrackingData, newItem: TrackingData): Boolean {
        return oldItem == newItem
    }
}