package com.example.jz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jz.R;
import com.example.jz.tts.tts;

public class WmActivity extends AppCompatActivity {
    private tts tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guanyu);
        ImageButton img = findViewById(R.id.bf);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts = new tts(getApplicationContext());
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String textToSpeak = "版本CV001.0关于应用学习这个项目，用于理解Activity，Fragment，数据库等相关内容好好学习，天天向上开发者计科GT2302班，张鹏，陈欣欣，吴军宜，李雪研，胡溢开发时间2024年5月24日"; // 指定的文字
                        tts.speak(textToSpeak);
                    }
                });
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