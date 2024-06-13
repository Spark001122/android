package com.example.jz.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.jz.activity.LoginActivity;
import com.example.jz.bean.SzBean;
import com.example.jz.bean.UserBean;
import com.example.jz.db.Database;

public class UserDao {
    public static SQLiteDatabase db = Database.db;
    //注册用户
    public static long addUser(UserBean user){
        ContentValues values = new ContentValues();
        values.put("username",user.getUsername());
        values.put("password",user.getPassword());
        values.put("phone",user.getPhone());
        values.put("sex",user.getSex());
        values.put("address",user.getAddress());
        long row = 0;
        try{
            row = db.insert("user",null,values);
        }catch (Exception e){
            return 0;
        }
        return row;
    }

    public static UserBean login(String username,String password){
        String sql = "select * from user where username=? and password=?";
        String values[] = {username,password};
        Log.d("TAG", username+password);
        Cursor res= db.rawQuery(sql,values);
        while(res.moveToNext()){

            String name = res.getString(0);
            String pwd = res.getString(1);
            String phone = res.getString(2);
            String sex = res.getString(3);
            String address = res.getString(4);

            UserBean user = new UserBean(name,pwd,phone,sex,address);
            return user;

        }
        return null;
    }

    public static UserBean getBeanById(String username){
        String sql = "select * from user where username=?";
        String values[] = {username};
        Cursor res = db.rawQuery(sql,values);
        while(res.moveToNext()){
            String name = res.getString(0);
            String pwd = res.getString(1);
            String phone = res.getString(2);
            String sex = res.getString(3);
            String address = res.getString(4);

            UserBean user = new UserBean(name,pwd,phone,sex,address);
            return user;
        }
        return null;
    }

    public static long updateUser(UserBean user){

        ContentValues values = new ContentValues();
        values.put("password",user.getPassword());
        values.put("phone",user.getPhone());
        values.put("sex",user.getSex());
        values.put("address",user.getAddress());
        long rowId = db.update("user",values,"username=?",new String[]{user.getUsername()});
        return rowId;

    }
}
