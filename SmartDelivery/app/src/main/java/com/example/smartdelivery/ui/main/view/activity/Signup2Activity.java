package com.example.smartdelivery.ui.main.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.smartdelivery.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
public class Signup2Activity extends AppCompatActivity {
    //회원가입
    private static final String TAG = "Signup User";
    private EditText userid, userpw, username,
            userphone, useraddress, useremail;

    private ImageButton sign_btn;
    private PreferenceHelper preferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        preferenceHelper = new PreferenceHelper(this);

        userid = (EditText) findViewById(R.id.e_id);
        userpw = (EditText) findViewById(R.id.e_pw);
        username = (EditText) findViewById(R.id.e_name);
        userphone = (EditText) findViewById(R.id.e_phone);
        useraddress = (EditText) findViewById(R.id.e_address);
        useremail = (EditText) findViewById(R.id.e_email);

        sign_btn = (ImageButton) findViewById(R.id.sign_btn);

        sign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerMe();
            }
        });
    }

    private void registerMe() {
        final String id = userid.getText().toString();
        final String password = userpw.getText().toString();
        final String name = username.getText().toString();
        final String phone = userphone.getText().toString();
        final String address = useraddress.getText().toString();
        final String email = useremail.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RegisterInterface.REGIST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterInterface api = retrofit.create(RegisterInterface.class);
        Call<String> call = api.getUserRegist(id, password, name, phone, address, email);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull retrofit2.Response<String> response) {

                if (response.isSuccessful() && response.body() != null) {
                    Log.e("onSuccess", "success");

                    String jsonResponse = response.body();
                    try {
                        parseRegData(jsonResponse);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Log.e(TAG, "실패");

            }
        });
    }

    private void parseRegData(String response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        if (jsonObject.optString("status").equals("true")) {
            saveInfo(response);
            Toast.makeText(Signup2Activity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Signup2Activity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
        }
    }

    private void saveInfo(String response) {
        preferenceHelper.putIsLogin(true);
        try
        {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("status").equals("true"))
            {
                JSONArray dataArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < dataArray.length(); i++)
                {
                    JSONObject dataobj = dataArray.getJSONObject(i);
                    preferenceHelper.putUserid(dataobj.getString("id"));
                    preferenceHelper.putUserpw(dataobj.getString("password"));
                    preferenceHelper.putUsername(dataobj.getString("name"));
                    preferenceHelper.putUserphone(dataobj.getString("phone"));
                    preferenceHelper.putUseraddress(dataobj.getString("address"));
                    preferenceHelper.putUseremail(dataobj.getString("email"));
                }
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}




*/