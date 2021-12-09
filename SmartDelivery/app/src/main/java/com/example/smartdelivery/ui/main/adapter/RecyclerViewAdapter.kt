package com.example.smartdelivery.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.smartdelivery.R
import com.example.smartdelivery.data.room.TrackingData
import com.example.smartdelivery.databinding.HolderDeliveryListBinding
import com.example.smartdelivery.ui.main.view.fragment.MainFragmentDirections
import com.example.smartdelivery.util.Diff

class RecyclerViewAdapter : ListAdapter<TrackingData, RecyclerViewAdapter.DeliveryHolder>(Diff) {

    var data = ArrayList<TrackingData>()

    inner class DeliveryHolder(private val binding: HolderDeliveryListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(trackingData: TrackingData) {
            binding.data = trackingData
        }

        init {
            binding.root.setOnClickListener {
                binding.root.findNavController().navigate(
                    MainFragmentDirections.actionMainFragmentToDetailFragment(
                        data[adapterPosition].company_code,
                        data[adapterPosition].trackingNum
                    )
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryHolder {
        val binding =
            HolderDeliveryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DeliveryHolder(binding)
    }

    override fun onBindViewHolder(holder: DeliveryHolder, position: Int) {
        holder.bind(data[position])
    }
}