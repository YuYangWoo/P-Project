package com.example.smartdelivery.ui.main.view.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.example.codingassignment.ui.base.BaseDialog
import com.example.smartdelivery.R
import com.example.smartdelivery.databinding.DialogLoadingBinding

// Loading Progress Bar
class ProgressDialog(context: Context) : BaseDialog<DialogLoadingBinding>(context, R.layout.dialog_loading) {
    override fun init() {
        super.init()
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        var loadingAnimation = binding.pbLoading.drawable as AnimationDrawable
        loadingAnimation.start()
    }
}