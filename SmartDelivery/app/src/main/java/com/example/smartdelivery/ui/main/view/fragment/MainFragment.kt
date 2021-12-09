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

    private val addViewModel: AddViewModel by sharedViewModel()
    private val TAG = "MainFragment"
    private val recyclerAdapter = RecyclerViewAdapter()
    override fun init() {
        super.init()
        recyclerView()
        btnAdd()
        roomListObserver()
    }

    private fun recyclerView() {
        with(binding.recyclerView) {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun roomListObserver() {
        addViewModel.deliveryList.observe(viewLifecycleOwner, Observer { data ->
            data.let {
                recyclerAdapter.data = addViewModel.deliveryList.value as ArrayList<TrackingData>
                recyclerAdapter.submitList(addViewModel.deliveryList.value as ArrayList<TrackingData>)
                Log.d(TAG, "roomListObserver: ${addViewModel.deliveryList.value}")
            }

        })
    }

    private fun btnAdd() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToAddFragment())
        }
    }

}