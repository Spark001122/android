package com.example.jz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jz.R;
import com.example.jz.bean.SzBean;
import com.example.jz.dao.SzDao;

import org.w3c.dom.Text;

public class ShouZhiGuanLiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_zhi_guan_li);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        TextView num = findViewById(R.id.tv_test);
        EditText yt = findViewById(R.id.yongtu_date);
        EditText date = findViewById(R.id.edt_date);
        EditText type = findViewById(R.id.edt_type);
        EditText price = findViewById(R.id.edt_money);
        EditText sm = findViewById(R.id.edt_state);
        SzBean sz = SzDao.getBeanById(id);

        num.setText(sz.getNum());
        yt.setText(sz.getYt());
        date.setText(sz.getDate());
        type.setText(sz.getType());
        price.setText(sz.getPrice());
        sm.setText(sz.getSm());




        Button update_btn = findViewById(R.id.btn_update);
        Button del_btn = findViewById(R.id.btn_delete);

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long i = SzDao.updateSz(new SzBean(id,date.getText().toString(),type.getText().toString(),price.getText().toString(),yt.getText().toString(),sm.getText().toString()));
                if(i > 0){
                    Toast.makeText(ShouZhiGuanLiActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ShouZhiGuanLiActivity.this,ShowYeActivity.class));
                }else{
                    Toast.makeText(ShouZhiGuanLiActivity.this,"修改失败",Toast.LENGTH_SHORT).show();
                }
            }
        });

        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long i = SzDao.delData(id);
                if(i > 0){
                    Toast.makeText(ShouZhiGuanLiActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ShouZhiGuanLiActivity.this,ShowYeActivity.class));
                }
            }
        });

    }
}