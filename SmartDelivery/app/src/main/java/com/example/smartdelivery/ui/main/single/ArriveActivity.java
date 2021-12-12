package com.example.smartdelivery.ui.main.single;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.smartdelivery.R;
import com.example.smartdelivery.ui.main.single.SingleItem;
import com.example.smartdelivery.ui.main.single.SingleItemView;

import java.util.ArrayList;
import java.lang.reflect.Array;

import androidx.appcompat.app.AppCompatActivity;

public class ArriveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrive);

        ListView listView=findViewById(R.id.listView);
        SingleAdapter adapter=new SingleAdapter();
        adapter.addItem(new SingleItem(R.drawable.img_test,"송장번호1234","3/11 20:11"));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int i, long id) {
                Intent intent=new Intent(getApplicationContext(),Arrive2Activity.class);

                startActivity(intent);

            }
        });


    }

    class SingleAdapter extends BaseAdapter{
        ArrayList<SingleItem> items=new ArrayList<SingleItem>();

        @Override
        public int getCount(){

            return items.size();
        }
        public void addItem(SingleItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position){
            return items.get(position);
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        //어댑터가 데이터 관리, 뷰생성
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            SingleItemView singleItemView = null;

            if(convertView==null){
                singleItemView=new SingleItemView(getApplicationContext());
            }else{
                singleItemView=(SingleItemView)convertView;
            }
            SingleItem item=items.get(position);
            SingleItemView.setNum(item.getInvoice_num());
            SingleItemView.setTime(item.getArrive_time());
            SingleItemView.setImg(item.getInvoice_image());
            return  singleItemView;
        }
    }




}
