package com.example.jz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.jz.activity.LoginActivity;
import com.example.jz.activity.ShowYeActivity;
import com.example.jz.db.Database;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Database dataBase = new Database(MainActivity.this);
        SQLiteDatabase db = dataBase.getWritableDatabase();//获取连接
        dataBase.db = db;

        startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }
}