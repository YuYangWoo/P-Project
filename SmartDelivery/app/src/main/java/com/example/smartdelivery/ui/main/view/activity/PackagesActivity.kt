package com.example.smartdelivery.ui.main.view.activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.smartdelivery.R
import com.example.smartdelivery.data.model.request.PackagesRequest
import com.example.smartdelivery.data.model.response.CompanyList
import com.example.smartdelivery.data.model.response.PackagesList
import com.example.smartdelivery.data.model.response.PackagesResponse
import com.example.smartdelivery.data.shared.MySharedPreferences
import com.example.smartdelivery.databinding.ActivityArriveBinding

import com.example.smartdelivery.ui.base.BaseActivity
import com.example.smartdelivery.ui.main.view.dialog.ProgressDialog
import com.example.smartdelivery.ui.main.viewmodel.AddViewModel
import com.example.smartdelivery.ui.main.viewmodel.MainViewModel
import com.example.smartdelivery.ui.main.viewmodel.PackagesViewModel
import com.example.smartdelivery.util.Resource
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class PackagesActivity :BaseActivity<ActivityArriveBinding>(R.layout.activity_arrive){

    //택배 도착 조회 액티비티
    private var packagesResponse=PackagesResponse();
    private var packagesRequest=PackagesRequest();
    private val packagesViewModel:PackagesViewModel by viewModel()
    private val TAG="PackagesActivity"


    private val dialog by lazy {
        ProgressDialog(this)
    }

    //도착한 택배 정보 가져오기,아이디 기준으로
    override fun init(){
        super.init()
        packagesRequest.jwt= "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWR4Ijo2LCJpYXQiOjE2MzkzODczNTAsImV4cCI6MTY0MDU5Njk1MH0.UgNaYKL-kdAQdKOWhkYlNzWeJ8LlGt6M3VKpeVsY9oA"
            initViewModel()

        binding.btnCheck.setOnClickListener{
            Toast.makeText(getApplicationContext(),"수령완료되었습니다.", Toast.LENGTH_LONG).show();
            startActivity(Intent(this,MenuActivity::class.java))

        }
    }

    //도착한 택배 서버 통신
    private fun initViewModel() {
        packagesViewModel.packagesApiCall(packagesRequest).observe(this@PackagesActivity,
            androidx.lifecycle.Observer { resource ->
                when (resource.status) {
                   Resource.Status.SUCCESS -> {
                        dialog.dismiss()
                        when (resource.data!!.code()) {
                            200 -> {
                                packagesResponse = resource.data.body()!!
                                packagesResponse.createdAt= MySharedPreferences.setArriveNumber(this@PackagesActivity,binding.arriveTime.text.toString())
                                    .toString()

                                packagesResponse.trackingNumber=MySharedPreferences.setArriveNumber(this@PackagesActivity,binding.arriveNum.text.toString())
                                    .toString()

                                packagesResponse.trackingNumber=MySharedPreferences.setArriveImg(this@PackagesActivity,binding.arriveImg.toString())
                                    .toString()




                            }
                            else -> {
                                toast(this, "에러요")
                            }
                        }
                    }
                }
            })
    }


        }








