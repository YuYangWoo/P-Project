package com.example.smartdelivery.ui.main.single;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smartdelivery.R;

import androidx.annotation.Nullable;

public class SingleItemView extends LinearLayout {

    static TextView single_num;
    static TextView single_time;
    static ImageView single_img;

    public SingleItemView(Context context){
        super(context);
        init(context);
    }
    public SingleItemView(Context context, @Nullable AttributeSet attrs){
        super(context,attrs);
    }

    private void init(Context context){
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.single_item_list,this,true);

        single_num=findViewById(R.id.single_num);
        single_time=findViewById(R.id.single_time);
        single_img=findViewById(R.id.single_img);
    }

    public static void setNum(String num){

        single_num.setText(num);
    }
    public static void setTime(String time){

        single_time.setText(time);
    }
    public  static void setImg(int img){

        single_img.setImageResource(img);
    }

}
