package com.example.jz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jz.R;
import com.example.jz.bean.ImageBean;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class LicaiActivity extends AppCompatActivity {
    private Banner banner;
    private List<ImageBean> imageList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licaizixun);
        banner = findViewById(R.id.banner);

        imageList.add(new ImageBean(R.drawable.th,"图片1"));
        imageList.add(new ImageBean(R.drawable.th2,"图片2"));
        imageList.add(new ImageBean(R.drawable.th3,"图片3"));
        banner.setAdapter(new BannerImageAdapter<ImageBean>(imageList){
            @Override
            public void onBindView(BannerImageHolder holder, ImageBean imageList, int position, int size) {
                holder.imageView.setImageResource(imageList.getImg());
            }
        }).addBannerLifecycleObserver(this).setIndicator(new CircleIndicator(this));
        TextView back = findViewById(R.id.back_ccloth01);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}