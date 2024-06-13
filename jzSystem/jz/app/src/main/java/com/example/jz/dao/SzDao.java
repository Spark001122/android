package com.example.jz.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jz.bean.SzBean;
import com.example.jz.bean.UserBean;
import com.example.jz.db.Database;

import java.util.ArrayList;

public class SzDao {
    public static SQLiteDatabase db = Database.db;
    public static long addSz(SzBean sz){
        ContentValues values = new ContentValues();
        values.put("num",sz.getNum());
        values.put("date",sz.getDate());
        values.put("type",sz.getType());
        values.put("price",sz.getPrice());
        values.put("yt",sz.getYt());
        values.put("sm",sz.getSm());
        long row = 0;
        try{
            row = db.insert("jz",null,values);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return row;
    }

    public static ArrayList<SzBean> getAllData(){
        Cursor r = db.rawQuery("select * from jz",null);
        ArrayList<SzBean> list = new ArrayList<>();
        while(r.moveToNext()){
            String num = r.getString(0);
            String date = r.getString(1);
            String type = r.getString(2);
            String price = r.getString(3);
            String yt = r.getString(4);
            String sm = r.getString(5);
            SzBean sz = new SzBean(num,date,type,price,yt,sm);
            list.add(sz);
        }
        return list;
    }

    public static ArrayList<SzBean> getAllFoodById(String id){

        Cursor r = db.rawQuery("select * from  jz where num=?",new String[]{id});


        ArrayList<SzBean> list = new ArrayList<>();
        while(r.moveToNext()){
            String num = r.getString(0);
            String date = r.getString(1);
            String type = r.getString(2);
            String price = r.getString(3);
            String yt = r.getString(4);
            String sm = r.getString(5);
            SzBean sz = new SzBean(num,date,type,price,yt,sm);
            list.add(sz);
        }
        return list;
    }

    public static SzBean getBeanById(String id){
        String sql = "select * from jz where num=?";
        String values[] = {id};
        SzBean sz = new SzBean();
        Cursor r= db.rawQuery(sql,values);
        while(r.moveToNext()){
            sz.setNum(r.getString(0));
            sz.setDate(r.getString(1));
            sz.setType(r.getString(2));
            sz.setPrice(r.getString(3));
            sz.setYt(r.getString(4));
            sz.setSm(r.getString(5));
            return sz;
        }
        return null;
    }


    public static long updateSz(SzBean sz){

        ContentValues values = new ContentValues();
        values.put("date",sz.getDate());
        values.put("type",sz.getType());
        values.put("price",sz.getPrice());
        values.put("yt",sz.getYt());
        values.put("sm",sz.getSm());
        long rowId = db.update("jz",values,"num=?",new String[]{sz.getNum()});
        return rowId;

    }
    public static int delData(String id){
        try{
            db.execSQL("delete from jz where num=?",new String[]{id});
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

}
