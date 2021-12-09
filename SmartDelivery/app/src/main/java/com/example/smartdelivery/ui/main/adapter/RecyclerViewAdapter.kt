package com.example.smartdelivery.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.smartdelivery.data.room.TrackingData
import com.example.smartdelivery.databinding.HolderDeliveryListBinding
import com.example.smartdelivery.util.Diff

class RecyclerViewAdapter : ListAdapter<TrackingData, RecyclerViewAdapter.DeliveryHolder>(Diff) {

    var data = ArrayList<TrackingData>()
    inner class DeliveryHolder(private val binding : HolderDeliveryListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(trackingData: TrackingData) {
            binding.data = trackingData
            Log.d("MainFragment", "bind:어댑터${data.toString()} ")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryHolder {
        val binding = HolderDeliveryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Log.d("MainFragment", "bind:어댑터${data.toString()} ")

        return DeliveryHolder(binding)
    }

    override fun onBindViewHolder(holder: DeliveryHolder, position: Int) {
        Log.d("MainFragment", "bind:어댑터${data.toString()} ")

        holder.bind(data[position])
    }
}