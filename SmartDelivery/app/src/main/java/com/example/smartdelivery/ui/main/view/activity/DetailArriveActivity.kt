package com.example.smartdelivery.ui.main.view.activity

import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.smartdelivery.R
import com.example.smartdelivery.data.model.response.Package
import com.example.smartdelivery.data.shared.MySharedPreferences
import com.example.smartdelivery.databinding.ActivityDetailArriveBinding
import com.example.smartdelivery.ui.base.BaseActivity
import com.example.smartdelivery.ui.main.view.dialog.ProgressDialog
import com.example.smartdelivery.ui.main.viewmodel.PackageDetailViewModel
import com.example.smartdelivery.util.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailArriveActivity :
    BaseActivity<ActivityDetailArriveBinding>(R.layout.activity_detail_arrive) {

    var packageIdx: Int = 0
    private val packageDetailViewModel: PackageDetailViewModel by viewModel()
    private val dialog: ProgressDialog by lazy { ProgressDialog(this) }
    override fun init() {
        super.init()
        packageIdx = intent.getIntExtra("packageIdx", 0)!!
        initViewModel()
        binding.btnConfirm.setOnClickListener {
            finish()
        }
    }

    private fun initViewModel() {
        packageDetailViewModel.detailCall(packageIdx, MySharedPreferences.getJwt(this))
            .observe(this, Observer { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        dialog.dismiss()
                        when (resource.data!!.code()) {
                            200 -> {
                                Log.d("TAG", "initViewModel: ${resource.data.body()!!.result}")
                                binding.data = resource.data.body()!!.result
                                Glide.with(binding.imageView3)
                                    .load(resource.data.body()!!.result.imageUrl)
                                    .into(binding.imageView3)
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