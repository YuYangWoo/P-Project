package com.example.smartdelivery.ui.main.view.activity

import android.content.Intent
import com.example.smartdelivery.R
import com.example.smartdelivery.databinding.ActivityMenuBinding
import com.example.smartdelivery.ui.base.BaseActivity

class MenuActivity : BaseActivity<ActivityMenuBinding>(R.layout.activity_menu) {

    override fun init() {
        super.init()

        binding.menuarrive.setOnClickListener {
            val intent= Intent(this, PackagesActivity::class.java)
            startActivity(intent);
        }
        binding.menuinvoice.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
        binding.menuloss.setOnClickListener{
            val intent=Intent(this,LossActivity::class.java)
            startActivity(intent)
        }
        binding.btnOption.setOnClickListener {
            startActivity(Intent(this, OptionActivity::class.java))
        }


    }


}