package com.example.smartdelivery.ui.main.request;


import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;



public class RegisterRequest extends StringRequest {
    //서버 url tjfwjd
    final static private  String URL="http://52.79.239.78/app/signup";
    private Map<String,String> map;

    public  RegisterRequest(String userid, String userpw , String username, String useraddress, String userphone, String useremail, Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);

        map=new HashMap<>();
        map.put("id",userid);
        map.put("password",userpw);
        map.put("name",username);
        map.put("address",useraddress);
        map.put("phone",userphone);
        map.put("email",useremail+"");
    }
    @Override
    protected  Map<String,String> getParams() throws AuthFailureError{
        return map;
    }

}
