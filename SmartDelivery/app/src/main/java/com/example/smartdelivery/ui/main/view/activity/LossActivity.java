package com.example.smartdelivery.ui.main.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.smartdelivery.R;

import androidx.appcompat.app.AppCompatActivity;

public class LossActivity extends AppCompatActivity {
    //분실조회

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loss_none);
        Intent intent=new Intent(this,MenuActivity.class);
        ImageButton button=findViewById(R.id.btn_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}






