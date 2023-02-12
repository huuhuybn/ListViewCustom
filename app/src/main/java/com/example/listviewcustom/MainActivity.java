package com.example.listviewcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // ListView : là 1 view group  hỗ trợ hiển thị 1 array dữ liệu
    // array thì có thể là string array, int array hoặc object array
    // String name[] = {"TUNG","KIEN","THANG","AN"};
    // Student array , Car Array
    // 1 DATA
    // ListView trong xml
    // Adapter
    String name[] = {"TUNG","KIEN","THANG","AN","KIEN","THANG","AN","KIEN","THANG","AN","KIEN","THANG","AN","KIEN","THANG","AN","KIEN","THANG","AN","KIEN","THANG","AN","KIEN","THANG","AN","KIEN","THANG","AN"}; // data
    ListView lvData; // khai bao 1 bien
    StudentDAO sqlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlite = new StudentDAO(MainActivity.this);

        lvData = findViewById(R.id.lvData);
        ArrayList<Student> danhSach = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Student student = new Student("HUY " + i,
                    "09123456" + i,i);
            long kq = sqlite.insertSv(student);
            if (kq>0) Log.e("TC","TC");else Log.e("KTC","KTC");
        }

        danhSach = sqlite.getAllStudents();

        StudentAdapter studentAdapter =
                new StudentAdapter(danhSach);
        lvData.setAdapter(studentAdapter);

        /*ArrayAdapter<String> nameArray =
                new ArrayAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_1,name);
        lvData.setAdapter(nameArray);
        lvData.setOnItemClickListener((adapterView, view, i, l) -> {

        });
*/

    }
}
