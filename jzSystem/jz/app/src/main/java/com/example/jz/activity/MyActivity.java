package com.example.jz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jz.R;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        TextView qd = findViewById(R.id.signup);
        TextView day = findViewById(R.id.clock_day);
        ImageButton sy = findViewById(R.id.sy_btn);
        TextView exit = findViewById(R.id.exit);
        TextView shezhi = findViewById(R.id.my_inf);
        TextView women = findViewById(R.id.wm);
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,UpdateMyActivity.class));
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, LoginActivity.class));
            }
        });
        sy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,ShowYeActivity.class));
            }
        });
        qd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(day.getText().toString());
                num = num + 1;
                day.setText(String.valueOf(num));
            }
        });




        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyActivity.this, WmActivity.class));
            }
        });

        TextView lc = findViewById(R.id.licai);
        lc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyActivity.this, LicaiActivity.class));
            }
        });


    }
}