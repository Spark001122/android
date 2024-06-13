package com.example.jz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.jz.R;
import com.example.jz.bean.SzBean;

import java.util.ArrayList;

public class jzAdapter extends ArrayAdapter<SzBean> {
    private ArrayList<SzBean> list;
    public jzAdapter(@NonNull Context context, ArrayList<SzBean> list) {
        super(context, R.layout.list_item,list);
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item,parent,false);
        }
        TextView num = convertView.findViewById(R.id.id);
        TextView type = convertView.findViewById(R.id.leixng_list_type);
        TextView yt = convertView.findViewById(R.id.yongtu_list_typ1e);
        TextView price = convertView.findViewById(R.id.qian_list_jj);
        TextView date = convertView.findViewById(R.id.shijian_list_typ1e);

        SzBean sz = list.get(position);
        num.setText(sz.getNum());
        type.setText(sz.getType());
        yt.setText(sz.getYt());
        price.setText(sz.getPrice());
        date.setText(sz.getDate());


        return convertView;
    }
}
