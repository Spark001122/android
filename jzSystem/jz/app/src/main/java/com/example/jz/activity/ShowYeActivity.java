package com.example.jz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jz.R;
import com.example.jz.adapter.jzAdapter;
import com.example.jz.bean.SzBean;
import com.example.jz.dao.SzDao;

import java.util.ArrayList;
import java.util.List;

public class ShowYeActivity extends AppCompatActivity {
    jzAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ye);
        Button add = findViewById(R.id.add_btn);


        listView = this.findViewById(R.id.main_lv);
        ArrayList<SzBean> data = SzDao.getAllData();
        if(data == null || data.size() == 0){
            listView.setAdapter(null);
        }else{
            adapter = new jzAdapter(this,data);
            listView.setAdapter(adapter);
        }

        ImageButton my_imgbtn = findViewById(R.id.my_btn);
        my_imgbtn.setOnClickListener(new View.OnClickListener() {  //跳转到我的
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowYeActivity.this,MyActivity.class));
            }
        });


        add.setOnClickListener(new View.OnClickListener() {  //跳转到添加数据
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowYeActivity.this,AddDataActivity.class));
            }
        });



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SzBean temp = adapter.getItem(position);
                Intent intent = new Intent(ShowYeActivity.this,ShouZhiGuanLiActivity.class);
                intent.putExtra("id",temp.getNum());
                startActivity(intent);
            }
        });

        TextView total_sr = findViewById(R.id.main_tv_month_in_money);
        TextView total_zc = findViewById(R.id.main_tv_month_out_money);
        double sum_sr = Double.parseDouble(total_sr.getText().toString());
        double sum_zc = Double.parseDouble(total_zc.getText().toString());
        if(adapter != null || data.size() != 0){

            for(int i = 0;i < adapter.getCount();i++){
                SzBean sz = adapter.getItem(i);

                String type = sz.getType();
                String price = sz.getPrice();
                if(type.equals("收入")){
                    sum_sr = sum_sr + Double.parseDouble(price);
                }else{
                    sum_zc = sum_zc + Double.parseDouble(price);
                }

            }
        }
        total_sr.setText(String.valueOf(sum_sr));
        total_zc.setText(String.valueOf(sum_zc));

    }
}