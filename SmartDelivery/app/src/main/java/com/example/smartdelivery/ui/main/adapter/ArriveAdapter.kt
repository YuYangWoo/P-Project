package com.example.smartdelivery.ui.main.adapter


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.smartdelivery.R
import com.example.smartdelivery.data.model.response.Package
import com.example.smartdelivery.databinding.HolderArriveListBinding
import com.example.smartdelivery.ui.main.view.activity.DetailArriveActivity
import com.example.smartdelivery.util.DiffArrive

class ArriveAdapter : ListAdapter<com.example.smartdelivery.data.model.response.Package, ArriveAdapter.ArriveHolder>(DiffArrive) {

    var data = ArrayList<Package>()
    inner class ArriveHolder(private val binding: HolderArriveListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: com.example.smartdelivery.data.model.response.Package) {
            Log.d("TAG", "bind: ${data}")
            binding.data = data

            when (data.status) {
                1 -> {
                    binding.txtStatus.text = "분실 택배"
                    binding.imgBox.setImageResource(R.drawable.box2)
                    binding.cstLy.background = binding.root.resources.getDrawable(R.drawable.square2,null)
                }
                2 -> {
                    binding.txtStatus.text = "수령 택배"
                    binding.imgBox.setImageResource(R.drawable.box1)
                    binding.cstLy.background = binding.root.resources.getDrawable(R.drawable.square3,null)
                }
                else -> {
                    binding.txtStatus.text = "도착 택배"
                    binding.imgBox.setImageResource(R.drawable.box3)
                    binding.cstLy.background = binding.root.resources.getDrawable(R.drawable.square1,null)

                }
            }

        }

        init {
            binding.root.setOnClickListener {
                binding.root.context.startActivity(Intent(binding.root.context, DetailArriveActivity::class.java))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArriveHolder {
        val binding = HolderArriveListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArriveHolder(binding)
    }

    override fun onBindViewHolder(holder: ArriveHolder, position: Int) {
        holder.bind(data[position])
    }
}