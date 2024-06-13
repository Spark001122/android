package com.example.jz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jz.R;
import com.example.jz.bean.SzBean;
import com.example.jz.dao.SzDao;

public class AddDataActivity extends AppCompatActivity {
    String type = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        EditText num = findViewById(R.id.id_edittext);
        EditText price = findViewById(R.id.jinexinxi_edittext);
        RadioButton sr = findViewById(R.id.radio_sr);
        RadioButton zc = findViewById(R.id.radio_zc);


        EditText yt = findViewById(R.id.xiaofeiyongtu_edittext);
        EditText date = findViewById(R.id.riqi_edittext);
        EditText sm = findViewById(R.id.beizhushuoming_edittext);
        Button add_btn = findViewById(R.id.tianjia_btn);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sr.isChecked()){
                    type = "收入";
                }else{
                    type = "支出";
                }
                long i = SzDao.addSz(new SzBean(num.getText().toString(),date.getText().toString(), type,price.getText().toString(),yt.getText().toString(),sm.getText().toString()));
                if(i > 0){
                    Toast.makeText(AddDataActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddDataActivity.this,ShowYeActivity.class));
                }else{
                    Toast.makeText(AddDataActivity.this,"添加失败，id重复",Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView back = findViewById(R.id.back_ccloth);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}