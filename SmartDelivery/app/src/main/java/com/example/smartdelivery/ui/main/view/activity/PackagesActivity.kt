package com.example.smartdelivery.ui.main.view.activity

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartdelivery.R
import com.example.smartdelivery.data.model.response.Package
import com.example.smartdelivery.data.shared.MySharedPreferences
import com.example.smartdelivery.databinding.ActivityArriveBinding
import com.example.smartdelivery.ui.base.BaseActivity
import com.example.smartdelivery.ui.main.adapter.ArriveAdapter
import com.example.smartdelivery.ui.main.view.dialog.ProgressDialog
import com.example.smartdelivery.ui.main.viewmodel.PackagesViewModel
import com.example.smartdelivery.util.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel


class PackagesActivity : BaseActivity<ActivityArriveBinding>(R.layout.activity_arrive) {

    private val packagesViewModel: PackagesViewModel by viewModel()
    private val TAG = "PackagesActivity"

    private val arriveAdapter = ArriveAdapter()
    private val dialog by lazy {
        ProgressDialog(this)
    }

    override fun init() {
        super.init()
        requestPackage()
    }

    private fun requestPackage() {
        packagesViewModel.packagesApiCall(MySharedPreferences.getJwt(this)).observe(this, Observer{ resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        dialog.dismiss()
                        when (resource.data!!.code()) {
                            200 -> {
                                Log.d(TAG, "initViewModel: ${resource.data.body()!!.result}")
                                with(binding.recyclerArrive) {
                                    layoutManager = LinearLayoutManager(this@PackagesActivity)
                                    adapter = arriveAdapter.apply {
                                        data = resource.data.body()!!.result as ArrayList<Package>
                                        submitList(data)
                                        Log.d(TAG, "requestPackage: dd${data}")
                                    }
                                }
                            }
                            else -> {
                                toast(this, "에러요")
                            }
                        }
                    }
                    Resource.Status.LOADING -> {
                        dialog.show()
                    }
                    Resource.Status.ERROR -> {
                        Log.d(TAG, "initViewModel: ${resource.message}")
                        dialog.dismiss()
                    }
                }

        })
    }

}








