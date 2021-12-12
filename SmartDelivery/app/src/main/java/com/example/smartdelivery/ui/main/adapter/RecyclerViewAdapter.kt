package com.example.smartdelivery.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.smartdelivery.data.room.TrackingData
import com.example.smartdelivery.databinding.HolderDeliveryListBinding
import com.example.smartdelivery.ui.main.view.fragment.MainFragmentDirections
import com.example.smartdelivery.ui.main.viewmodel.AddViewModel
import com.example.smartdelivery.util.Diff
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecyclerViewAdapter(private val addViewModel: AddViewModel) :
    ListAdapter<TrackingData, RecyclerViewAdapter.DeliveryHolder>(Diff) {

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
            binding.btnClose.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    addViewModel.deleteData(
                        TrackingData(
                            binding.data!!.trackingNum,
                            binding.data!!.company,
                            binding.data!!.company_code,
                            binding.data!!.itemName,
                            binding.data!!.complete
                        )
                    )
                }
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