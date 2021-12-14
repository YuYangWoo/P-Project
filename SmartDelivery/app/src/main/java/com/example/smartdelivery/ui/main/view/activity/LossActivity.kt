package com.example.smartdelivery.ui.main.view.activity

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartdelivery.R
import com.example.smartdelivery.data.model.response.Package
import com.example.smartdelivery.data.shared.MySharedPreferences
import com.example.smartdelivery.databinding.ActivityLossBinding
import com.example.smartdelivery.ui.base.BaseActivity
import com.example.smartdelivery.ui.main.adapter.ArriveAdapter
import com.example.smartdelivery.ui.main.view.dialog.ProgressDialog
import com.example.smartdelivery.ui.main.viewmodel.LossViewModel
import com.example.smartdelivery.util.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class LossActivity : BaseActivity<ActivityLossBinding>(R.layout.activity_loss) {

    private val lossViewModel: LossViewModel by viewModel()
    private val dialog: ProgressDialog by lazy { ProgressDialog(this) }
    private val arriveAdapter by lazy { ArriveAdapter() }

    override fun init() {
        super.init()
        initViewModel()
    }

    private fun initViewModel() {
        lossViewModel.lossApiCall(MySharedPreferences.getJwt(this)).observe(this, Observer { resource ->
            when (resource.status) {
                Resource.Status.SUCCESS -> {
                    dialog.dismiss()
                    when (resource.data!!.code()) {
                        200 -> {
                            Log.d("TAG", "initViewModel: ${resource.data.body()!!}")
                            with(binding.recyclerArrive) {
                                layoutManager = LinearLayoutManager(this@LossActivity)
                                adapter = arriveAdapter.apply {
                                    data = resource.data.body()!!.result as ArrayList<Package>
                                    submitList(data)
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
                    Log.d("TAG", "initViewModel: ${resource.message}")
                    dialog.dismiss()
                }
            }
        })
    }

}