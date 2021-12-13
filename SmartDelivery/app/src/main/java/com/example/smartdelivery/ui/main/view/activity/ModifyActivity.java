package com.example.smartdelivery.ui.main.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartdelivery.R;

public class ModifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//회원정보 수정
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Intent intent=new Intent(this,ModifyActivity2.class);
        Button button=findViewById(R.id.modify_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }

}