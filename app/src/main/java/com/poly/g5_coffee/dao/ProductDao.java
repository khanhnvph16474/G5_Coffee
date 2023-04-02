package com.poly.g5_coffee.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.poly.g5_coffee.DBhelper;
import com.poly.g5_coffee.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private SQLiteDatabase db;

    public  ProductDao(Context context) {
        DBhelper dbHelper = new DBhelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(Product obj){
        ContentValues values = new ContentValues();
        values.put("nameSp", obj.nameSp);
        values.put("price", obj.price);
        values.put("soLuong", obj.soluong);
        values.put("message", obj.message);

        return db.insert("listProduct", null, values);
    }

    public int update(Product obj){
        ContentValues values = new ContentValues();
        values.put("tenSp", obj.nameSp);
        values.put("price", obj.price);
        values.put("soLuong", obj.soluong);
        values.put("message", obj.message);

        return db.update("listProduct", values, "id=?", new String[]{String.valueOf(obj.id)});
    }

    public int delete(String id){
        return db.delete("listProduct", "id=?", new String[]{id});
    }

    public List<Product> getAll(){
        String sql = "SELECT * FROM listProduct";
        return getData(sql);
    }

    public Product getID(String id){
        String sql = "SELECT * FROM listProduct WHERE id=?";
        List<Product> list = getData(sql, id);
        return list.get(0);
    }

    @SuppressLint("Range")
    private List<Product> getData(String sql, String...selectionArgs){


        List<Product> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()){
            Product obj = new Product();
            obj.id = Integer.parseInt(c.getString(c.getColumnIndex("id")));
            obj.nameSp = c.getString(c.getColumnIndex("nameSp"));
            obj.price = Integer.parseInt(c.getString(c.getColumnIndex("price")));
            obj.message = c.getString(c.getColumnIndex("message"));
            list.add(obj);
        }
        return list;
    }
}
