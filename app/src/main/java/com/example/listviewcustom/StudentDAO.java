package com.example.listviewcustom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class StudentDAO {

    private MyStudentSqlite sqlite;

    public StudentDAO(Context context){
        sqlite = new MyStudentSqlite(context);
    }

    public long insertSv(Student sv){
        // B1 : khoi tao - ghép dữ liệu với tên cột tương ứng
        ContentValues values = new ContentValues();
        values.put("id",sv.getId());
        values.put("name",sv.getName());
        values.put("phone",sv.getPhone());
        // B2 : goi cau lenh insert
        return sqlite.getWritableDatabase().insert("sv",null,values);
    }

    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> students = new ArrayList<>();
        String query = "SELECT * FROM sv";// sv la ten bang khai bao dong so 22
        Cursor cursor = sqlite.getReadableDatabase().rawQuery(query,null);
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

    public long update(Student sv){
        // B1 : khoi tao - ghép dữ liệu với tên cột tương ứng
        ContentValues values = new ContentValues();
        //values.put("id",sv.getId()); ko update dc khoa chinh
        values.put("name",sv.getName());
        values.put("phone",sv.getPhone());
        // B2 : goi cau lenh update
        // 1, ten bang . 2 . gia tri cot update thong qua values.
        // 2/ dieu kien where. ten cot = ?
        return sqlite.getWritableDatabase().update("sv",values, "id = ?",
                new String[]{String.valueOf(sv.getId())});
    }

    public long delete(Student sv){
        // B1 : khoi tao - ghép dữ liệu với tên cột tương ứng
        //ContentValues values = new ContentValues();
        //values.put("id",sv.getId()); ko update dc khoa chinh
        //values.put("name",sv.getName());
        //values.put("phone",sv.getPhone());
        // B2 : goi cau lenh update
        // 1, ten bang . 2 . gia tri cot update thong qua values.
        // 2/ dieu kien where. ten cot = ?
        return sqlite.getWritableDatabase().delete("sv", "id = ?",
                new String[]{String.valueOf(sv.getId())});
    }


}
