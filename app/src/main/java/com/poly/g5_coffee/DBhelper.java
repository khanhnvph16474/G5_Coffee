package com.poly.g5_coffee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBhelper extends SQLiteOpenHelper {
    static final String dbName="listapp";
    static final int dbVersion=2;

    public DBhelper(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // tạo bảng User
        String createTableUser=
                "create table listUser (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT NOT NULL, " +
                        "phoneNumber INTEGER NOT NULL," +
                        "diaChi TEXT NOT NULL," +
                        "userName TEXT NOT NULL," +
                        "password TEXT NOT NULL)";
        db.execSQL(createTableUser);

        // tạo bảng Product
        String createTableProduct=
                "create table listProduct (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nameSp TEXT NOT NULL, " +
                        "price INTEGER NOT NULL," +
                        "soluong INTEGER NOT NULL," +
                        "message TEXT NOT NULL)";
        db.execSQL(createTableProduct);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String createTableUser = "drop table if exists listUser";
        db.execSQL(createTableUser);
        String createTableProduct = "drop table if exists listProduct";
        db.execSQL(createTableProduct);
        onCreate(db);
    }

}