package com.example.smartdelivery.ui.main.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.smartdelivery.R
import com.example.smartdelivery.data.shared.MySharedPreferences
import com.example.smartdelivery.databinding.ActivitySetting2Binding
import com.example.smartdelivery.ui.base.BaseActivity

class OptionActivity : BaseActivity<ActivitySetting2Binding>(R.layout.activity_setting2) {
    //알림 설정
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting2)
    }

}