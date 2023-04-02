package com.poly.g5_coffee.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.poly.g5_coffee.DBhelper;
import com.poly.g5_coffee.FragmentLogin.Dangki_Fragment;
import com.poly.g5_coffee.Model.Product;
import com.poly.g5_coffee.Model.User;
import com.poly.g5_coffee.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private SQLiteDatabase db;

    public UserDao(Context context) {
        DBhelper dBhelper = new DBhelper(context);
        db =dBhelper.getWritableDatabase();
    }


    public long insert(User obj){

        ContentValues values = new ContentValues();
        values.put("name", obj.name);
        values.put("phoneNumber", obj.phoneNumber);
        values.put("diaChi", obj.diaChi);
        values.put("userName", obj.userName);
        values.put("password", obj.password);

        return db.insert("listUser", null, values);

    }
    public int update(User obj){
        ContentValues values = new ContentValues();
        values.put("name", obj.name);
        values.put("phoneNumber", obj.phoneNumber);
        values.put("diaChi", obj.diaChi);
        values.put("userName", obj.userName);
        values.put("password", obj.password);
        long kq = db.update("listUser", values, "id=?", new String[]{String.valueOf(obj.id)});

        if(kq<0){
            return -1;
        }else {
            return 1;
        }

    }

    public List<User> getAll(){
        String sql = "SELECT * FROM listUser";
        return getData(sql);
    }

    public int checkLogin(String id, String password){
        String sql = "SELECT * FROM listUser WHERE userName=? AND password=?";
        List<User> list = getData(sql, id, password);
        if(list.size() == 0)
            return -1;
        return 1;
    }

    public User getID(String id){
        String sql = "SELECT * FROM listUser WHERE id=?";
        List<User> list = getData(sql, id);
        return list.get(0);
    }

    @SuppressLint("Range")
    private List<User> getData(String sql, String...selectionArgs){

        List<User> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()){
            User obj = new User();
            obj.name = c.getString(c.getColumnIndex("name"));
            obj.phoneNumber = c.getString(c.getColumnIndex("phoneNumber"));
            obj.diaChi = c.getString(c.getColumnIndex("diaChi"));
            obj.userName = c.getString(c.getColumnIndex("userName"));
            obj.password = c.getString(c.getColumnIndex("password"));
            list.add(obj);
        }
        return list;
    }

}
