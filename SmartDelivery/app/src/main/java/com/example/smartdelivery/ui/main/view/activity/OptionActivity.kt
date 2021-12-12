package com.example.smartdelivery.ui.main.view.activity

import android.content.Intent
import com.example.smartdelivery.R
import com.example.smartdelivery.data.shared.MySharedPreferences
import com.example.smartdelivery.databinding.ActivityOptionBinding
import com.example.smartdelivery.ui.base.BaseActivity

class OptionActivity : BaseActivity<ActivityOptionBinding>(R.layout.activity_option) {

    override fun init() {
        super.init()
        binding.btnLogout.setOnClickListener {
            MySharedPreferences.clearUser(this)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}