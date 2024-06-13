package com.example.jz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jz.R;
import com.example.jz.bean.UserBean;
import com.example.jz.dao.UserDao;

import org.w3c.dom.Text;

public class UpdateMyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_my);
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","");

        UserBean user = UserDao.getBeanById(username);
        EditText name = this.findViewById(R.id.tv_user);
        EditText pwd = findViewById(R.id.tv_pwd);
        EditText phone = findViewById(R.id.tv_phone);
        RadioButton man = findViewById(R.id.tv_man);
        RadioButton woman = findViewById(R.id.tv_woman);
        EditText address = findViewById(R.id.tv_lable);

        name.setText(user.getUsername());
        pwd.setText(user.getPassword());
        phone.setText(user.getPhone());
        if(user.getSex().equals("男")){
            man.setChecked(true);
        }else{
            woman.setChecked(true);
        }
        address.setText(user.getAddress());
        Button save = findViewById(R.id.btn_exit);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sex = "";
                if(man.isChecked()){
                    sex = "男";
                }else{
                    sex = "女";
                }

                UserBean newuser = new UserBean(name.getText().toString(),pwd.getText().toString(),phone.getText().toString(),sex,address.getText().toString());
                long i = UserDao.updateUser(newuser);
                if(i > 0){
                    Toast.makeText(UpdateMyActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });


    }
}