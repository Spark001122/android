package com.example.jz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jz.R;
import com.example.jz.bean.UserBean;
import com.example.jz.dao.UserDao;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.Username);
        EditText password = findViewById(R.id.Password);
        Button login = findViewById(R.id.Sign_in);
        Button reg = findViewById(R.id.Sign_up);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString() == "" || password.getText().toString() == ""){
                    Toast.makeText(LoginActivity.this,"请输入用户名或密码",Toast.LENGTH_SHORT).show();
                }else{

                    UserBean user = UserDao.login(username.getText().toString(),password.getText().toString());

                    if(user != null){
                        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username",username.getText().toString());
                        editor.apply();
                        Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this,ShowYeActivity.class));
                    }else{
                        Toast.makeText(LoginActivity.this,"登录失败，用户名或密码错误",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}