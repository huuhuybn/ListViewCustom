package com.example.listviewcustom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyStudentSqlite extends SQLiteOpenHelper {
    // dinh nghia. ten file cua sqlite
    // dinh nghia version cua sqlite
    // dinh nghia lop Context - Activity

    public MyStudentSqlite(Context context) {
        super(context, "sv.db", null, 1);
    }

    // goi vao 1 lan DAU TIEN
    // no such table
    // not found table
    // Xóa app trên máy ảo đi, chạy lại trên máy ảo
    @Override
    public void onCreate(SQLiteDatabase db) {
        String tao_bang_sv =
                "CREATE TABLE sv(id integer primary key,name varchar, phone varchar)";
        String tao_bang_gv =
                "CREATE TABLE gv(id integer primary key,name varchar, phone varchar)";
        db.execSQL(tao_bang_sv);
        db.execSQL(tao_bang_gv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }


    // DAO
}
