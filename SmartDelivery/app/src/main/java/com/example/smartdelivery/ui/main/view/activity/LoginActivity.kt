package com.example.smartdelivery.ui.main.view.activity

import android.content.Intent
import android.util.Log
import com.example.codingassignment.ui.base.BaseActivity
import com.example.smartdelivery.R
import com.example.smartdelivery.data.model.request.LoginRequest
import com.example.smartdelivery.data.model.response.LoginResponse
import com.example.smartdelivery.data.shared.MySharedPreferences
import com.example.smartdelivery.databinding.ActivityLoginBinding
import com.example.smartdelivery.ui.main.view.dialog.ProgressDialog
import com.example.smartdelivery.ui.main.viewmodel.LoginViewModel
import com.example.smartdelivery.util.Resource
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    private var loginResponse = LoginResponse()
    private var loginRequest = LoginRequest()
    private val loginViewModel: LoginViewModel by viewModel()

    private val dialog by lazy {
        ProgressDialog(this)
    }
    private val TAG = "LoginActivity"

    override fun init() {
        super.init()
        checkAutoLogin()
        btnLogin()
        checkBox()

        binding.button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        btnSignup.setOnClickListener{
            startActivity(Intent(this, SignupActivity::class.java))
        }
        btn_go_menu.setOnClickListener{
            startActivity(Intent(this,MenuActivity::class.java))
        }



    }

    // 자동 로그인
    private fun checkAutoLogin() {
        if (MySharedPreferences.getCheck(this@LoginActivity) &&
            MySharedPreferences.getUserId(this@LoginActivity).isNotBlank() &&
            MySharedPreferences.getUserPass(this@LoginActivity).isNotBlank()
        ) {
            binding.edtId.editText!!.setText(MySharedPreferences.getUserId(this@LoginActivity))
            binding.edtPassword.editText!!.setText(MySharedPreferences.getUserPass(this@LoginActivity))
            binding.checkBox.isChecked = true
            loginRequest.id = binding.edtId.editText!!.text.toString()
            loginRequest.password = binding.edtPassword.editText!!.text.toString()
            initViewModel()
        }
    }

    // 로그인 서버 API 통신
    private fun initViewModel() {
        loginViewModel.loginApiCall(loginRequest).observe(this@LoginActivity,
            androidx.lifecycle.Observer { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        dialog.dismiss()
                        when (resource.data!!.code()) {
                            200 -> {
                                Log.d(TAG, "initViewModel: ${resource.data.body()!!}")
                                loginResponse = resource.data.body()!!
                                loginApi()
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
                        dialog.dismiss()
                    }
                }
            })
    }

    // 체크박스가 체크되어있는지 체크되어 있지 않은지
    private fun checkBox() {
        binding.checkBox.setOnCheckedChangeListener { compoundButton, checked ->
            if (checked) {
                MySharedPreferences.setCheck(this@LoginActivity, binding.checkBox.isChecked)
            } else {
                MySharedPreferences.setCheck(this@LoginActivity, binding.checkBox.isChecked)
                MySharedPreferences.clearUser(this@LoginActivity)
            }
        }
    }

    // 로그인 버튼 클릭
    private fun btnLogin() {
        binding.btnLogin.setOnClickListener {
            loginRequest.id = binding.edtId.editText!!.text.toString()
            loginRequest.password = binding.edtPassword.editText!!.text.toString()
            initViewModel()
        }
    }

    // 로그인 체크
    private fun loginApi() {
        if(loginResponse.isSuccess) {
            MySharedPreferences.setUserId(this@LoginActivity, binding.edtId.editText!!.text.toString())
            MySharedPreferences.setUserPass(this@LoginActivity, binding.edtPassword.editText!!.text.toString())
//            MySharedPreferences.setLoginInformation(this@LoginActivity, loginResponse)
            startActivity(Intent(this@LoginActivity, MenuActivity::class.java))
            finish()
        }
    }


}