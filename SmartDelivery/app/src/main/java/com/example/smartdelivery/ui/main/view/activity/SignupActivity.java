package com.example.smartdelivery.ui.main.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.smartdelivery.R;
import com.example.smartdelivery.ui.main.request.RegisterRequest;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
//회원가입
    private EditText userid,userpw,username,userphone,useraddress,useremail;
    private Button sign_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        userid=findViewById(R.id.userid);
        userpw=findViewById(R.id.userpw);
        username=findViewById(R.id.username);
        userphone=findViewById(R.id.userphone);
        useraddress=findViewById(R.id.useraddress);
        useremail=findViewById(R.id.useremail);

        sign_btn=findViewById(R.id.sign_btn);

        sign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String USERID=userid.getText().toString();
                String USERPW=userpw.getText().toString();
                String USERNAME=username.getText().toString();
                String USERPHONE=userphone.getText().toString();
                String USERADDRESS=useraddress.getText().toString();
                String USEREMAIL=useremail.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            //회원가입 성공시
                            if(success) {

                                Toast.makeText( getApplicationContext(), "성공", Toast.LENGTH_SHORT ).show();
//                                Intent intent = new Intent( SignupActivity.this, testActivity.class );
//                                startActivity( intent );


                                //회원가입 실패시
                            } else {
                                Toast.makeText( getApplicationContext(), "실패", Toast.LENGTH_SHORT ).show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                //서버로 Volley를 이용해서 요청
                RegisterRequest registerRequest = new RegisterRequest(USERID,USERPW,USERNAME,USERPHONE,USERADDRESS,USEREMAIL, responseListener);
                RequestQueue queue = Volley.newRequestQueue( SignupActivity.this );
                queue.add( registerRequest );

            }
        });
    }

}
