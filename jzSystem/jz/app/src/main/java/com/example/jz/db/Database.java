package com.example.jz.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper{
    //数据库名称
    private static final String DB_NAME = "jz.db";

    //通过db来操作数据库
    public static SQLiteDatabase db = null;

    private static final int VERSION = 6;//数据库的版本

    private Context context;

    public Database(Context context){
        super(context,DB_NAME,null,VERSION,null);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        //取消外键
        db.execSQL("PRAGMA foreign_keys = false");

        db.execSQL("drop table if exists user"); //删除已存在的user和jz表，以确保可以创建新的表

        db.execSQL("create table user(username varchar(20) primary key," +
                "password varchar(20)," +
                "phone varchar(20)," +
                "sex varchar(3)," +
                "address varchar(20))");




        db.execSQL("drop table if exists jz");

        db.execSQL("create table jz(num varchar(20) primary key," +
                "date varchar(20)," +
                "type varchar(20)," +
                "price varchar(20)," +
                "yt varchar(20)," +
                "sm varchar(20))");

        db.execSQL("PRAGMA foreign_keys = true");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }
}
