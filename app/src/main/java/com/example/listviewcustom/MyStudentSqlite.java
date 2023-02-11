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
    public void insertSv(Student sv){
        // B1 : khoi tao - ghép dữ liệu với tên cột tương ứng
        ContentValues values = new ContentValues();
        values.put("id",sv.getId());
        values.put("name",sv.getName());
        values.put("phone",sv.getPhone());
        // B2 : goi cau lenh insert
        getWritableDatabase().insert("sv",null,values);
    }

    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> students = new ArrayList<>();
        String query = "SELECT * FROM sv";// sv la ten bang khai bao dong so 22
        Cursor cursor = getReadableDatabase().rawQuery(query,null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();// di chuyen vi tri dau tien cua con tro
            while (!cursor.isAfterLast()){ // kiem tra xem vi tri con trỏ hiện tại có phải là "last" ko - cuối cùng.
                // nếu ko phải thì đọc - nếu phải thì kết thúc vòng lặp
               int id = cursor.getInt(0);
               String name = cursor.getString(1);
               String phone = cursor.getString(2);
               // cac so 0 1 2 la thu tu của cột khi tạo bảng
                Student s = new Student(name,phone,id);
                students.add(s);
                // di chuyen toi vi tri tiep theo
                cursor.moveToNext();
            }// ngoac dong cua while
            cursor.close(); // dong ket noi vao con tro?
        }// ngoac dong cua if
        return students;
    }// ngoac dong cua getAllStudents
}
