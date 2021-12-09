package com.example.smartdelivery.ui.main.view.activity

import android.content.Intent
import com.example.codingassignment.ui.base.BaseActivity
import com.example.smartdelivery.R
import com.example.smartdelivery.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    override fun init() {
        super.init()
        binding.button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}