package com.example.smartdelivery.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.smartdelivery.data.model.response.TrackingDetail
import com.example.smartdelivery.data.model.response.TrackingResponse
import com.example.smartdelivery.databinding.HolderInvoiceListBinding
import com.example.smartdelivery.util.DiffInvoice

class InvoiceAdapter : ListAdapter<TrackingDetail, InvoiceAdapter.InvoiceHolder>(DiffInvoice) {
    var data = ArrayList<TrackingDetail>()
    inner class InvoiceHolder(private val binding: HolderInvoiceListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(trackingDetail: TrackingDetail) {
            binding.data = trackingDetail
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvoiceHolder {
        val binding = HolderInvoiceListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InvoiceHolder(binding)
    }

    override fun onBindViewHolder(holder: InvoiceHolder, position: Int) {
        holder.bind(data[position])
    }
}