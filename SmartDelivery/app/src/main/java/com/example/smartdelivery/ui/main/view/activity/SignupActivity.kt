package com.example.smartdelivery.ui.main.view.activity

import android.content.Intent

import android.util.Log
import com.example.smartdelivery.R
import com.example.smartdelivery.data.model.request.SignupRequest
import com.example.smartdelivery.data.model.response.SignupResponse
import com.example.smartdelivery.data.shared.MySharedPreferences
import com.example.smartdelivery.databinding.ActivitySignupBinding
import com.example.smartdelivery.ui.base.BaseActivity
import com.example.smartdelivery.ui.main.view.dialog.ProgressDialog
import com.example.smartdelivery.ui.main.viewmodel.SignupViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignupActivity : BaseActivity<ActivitySignupBinding>(R.layout.activity_signup){
//회원가입
    private var signupResponse=SignupResponse()
    private var signupRequest=SignupRequest()
    private val signupViewModel:SignupViewModel by viewModel()

    private val dialog by lazy {
        ProgressDialog(this)
    }
    private val TAG = "SignupActivity"

// 회원가입

    override fun init() {
        super.init()
        binding.signBtn.setOnClickListener {
            signupRequest.id = binding.eId.text.toString()
            signupRequest.password = binding.ePw.text.toString()
            signupRequest.name = binding.eName.text.toString()
            signupRequest.phone = binding.ePhone.text.toString()
            signupRequest.address = binding.eAddress.text.toString()
            signupRequest.email = binding.eEmail.text.toString()
            initViewModel()

            startActivity(Intent(this, SignupSuccessActivity::class.java))



        }

    }

    //회원가입 서버API 통신
    private fun initViewModel(){
        signupViewModel.SignupApiCall(signupRequest).observe(this@SignupActivity,
        androidx.lifecycle.Observer { resource->
            when(resource.status) {
                com.example.smartdelivery.util.Resource.Status.SUCCESS -> {
                    dialog.dismiss()
                    when (resource.data!!.code()) {
                        200 -> {
                            Log.d(TAG, "initViewModel: ${resource.data.body()!!}")
                            signupResponse = resource.data.body()!!
                        }
                        else -> {
                            toast(this, "에러요")
                        }
                    }
                }
            }
        })


}

    private  fun signupApi(){
        if (signupResponse.isSuccess){
            MySharedPreferences.setUserId(this@SignupActivity,binding.eId.text.toString())
            MySharedPreferences.setUserPass(this@SignupActivity,binding.ePw.text.toString())
            MySharedPreferences.setUserName(this@SignupActivity,binding.eName.text.toString())
            MySharedPreferences.setUserAddress(this@SignupActivity,binding.eAddress.text.toString())
            MySharedPreferences.setUserPhone(this@SignupActivity,binding.ePhone.text.toString())
            MySharedPreferences.setUserEmail(this@SignupActivity,binding.eEmail.text.toString())
            startActivity(Intent(this@SignupActivity, MenuActivity::class.java))
            finish()


        }

    }    }