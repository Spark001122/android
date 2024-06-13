package com.example.jz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.jz.R;
import com.example.jz.bean.UserBean;
import com.example.jz.dao.UserDao;

public class RegisterActivity extends AppCompatActivity {
    String sex = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText username = findViewById(R.id.et_reg_nickname);
        EditText password = findViewById(R.id.et_reg_pass);
        EditText phone = findViewById(R.id.et_reg_phone);
        RadioButton man = findViewById(R.id.radio_man);
        RadioButton woman = findViewById(R.id.radio_woman);
        EditText address = findViewById(R.id.et_reg_add);




        Button reg_btn = findViewById(R.id.reg);
        Button back = findViewById(R.id.back);
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(man.isChecked()){
                    sex = "男";
                }else{
                    sex = "女";
                }
                UserBean user = new UserBean(username.getText().toString(),password.getText().toString(),phone.getText().toString(),sex,address.getText().toString());
                long i = UserDao.addUser(user);
                if(i > 0){
                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(RegisterActivity.this,"注册失败，用户已存在",Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}