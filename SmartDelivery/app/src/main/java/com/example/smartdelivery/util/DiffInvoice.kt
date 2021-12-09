package com.example.smartdelivery.util

import androidx.recyclerview.widget.DiffUtil
import com.example.smartdelivery.data.model.response.TrackingDetail

object DiffInvoice : DiffUtil.ItemCallback<TrackingDetail>() {
    override fun areItemsTheSame(oldItem: TrackingDetail, newItem: TrackingDetail): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: TrackingDetail, newItem: TrackingDetail): Boolean {
        return oldItem == newItem
    }
}