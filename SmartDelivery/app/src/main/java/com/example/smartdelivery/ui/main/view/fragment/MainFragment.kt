package com.example.smartdelivery.ui.main.view.fragment

import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codingassignment.ui.base.BaseFragment
import com.example.smartdelivery.R
import com.example.smartdelivery.data.room.TrackingData
import com.example.smartdelivery.databinding.FragmentMainBinding
import com.example.smartdelivery.ui.main.adapter.RecyclerViewAdapter
import com.example.smartdelivery.ui.main.viewmodel.AddViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val addViewModel : AddViewModel by sharedViewModel()
    private val TAG = "MainFragment"
    private val recyclerAdapter = RecyclerViewAdapter()
    override fun init() {
        super.init()
        btnAdd()
        recyclerView()
        roomListObserver()
    }

    private fun roomListObserver() {
        addViewModel.getData().observe(viewLifecycleOwner, Observer {
            with(binding.recyclerView) {
                adapter = RecyclerViewAdapter().apply {
                data = it as ArrayList<TrackingData>
                submitList(data)
                }
                layoutManager = LinearLayoutManager(requireContext())
            }
            Log.d(TAG, "roomListObserver: ${it}")
            recyclerAdapter.data = it as ArrayList<TrackingData>
            recyclerAdapter.submitList(recyclerAdapter.data)
            Log.d(TAG, "roomListObserver: ${recyclerAdapter.data}")
        })
    }

    private fun btnAdd() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToAddFragment())
        }
    }

    private fun recyclerView() {
        with(binding.recyclerView) {
            adapter = RecyclerViewAdapter().apply {
//                data = arrayListOf(TrackingData("dd","dd","dd","dd","dd"))
//                submitList(data)
            }
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}