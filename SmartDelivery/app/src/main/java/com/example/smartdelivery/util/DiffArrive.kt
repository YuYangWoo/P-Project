package com.example.smartdelivery.util

import androidx.recyclerview.widget.DiffUtil
import com.example.smartdelivery.data.model.response.TrackingDetail

object DiffArrive : DiffUtil.ItemCallback<com.example.smartdelivery.data.model.response.Package>() {
    override fun areItemsTheSame(oldItem: com.example.smartdelivery.data.model.response.Package, newItem: com.example.smartdelivery.data.model.response.Package): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: com.example.smartdelivery.data.model.response.Package, newItem: com.example.smartdelivery.data.model.response.Package): Boolean {
        return oldItem == newItem
    }
}