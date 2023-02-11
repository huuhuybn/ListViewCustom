package com.example.listviewcustom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    private ArrayList<Student> danhSach;
    public StudentAdapter(ArrayList<Student> danhSach){
        this.danhSach = danhSach;
    }

    @Override
    public int getCount() {
        return danhSach.size(); // định nghĩa số lượng item mà adapter sẽ xử lý
    }

    @Override
    public Student getItem(int i) {
        return danhSach.get(i); // cách lấy dữ liệu của 1 hàng
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { // định nghĩa giao diện cho 1 hàng, và thiết lập dữ liệu hiển thị
        view = LayoutInflater.
                from(viewGroup.getContext()).inflate(R.layout.row_student,
                        viewGroup,false);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvPhone = view.findViewById(R.id.tvPhone);
        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Student student = getItem(i);
        tvName.setText(student.getName());
        tvPhone.setText(student.getPhone());
        // cách gán gía trị đơn giản nhưng chưa tối ưu cho ListView
        return view;
    }
}
