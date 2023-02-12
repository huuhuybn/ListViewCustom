package com.example.listviewcustom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
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
        Button btnDel = view.findViewById(R.id.btnDelete);
        Button btnUpdate = view.findViewById(R.id.btnUpdate);
        btnDel.setOnClickListener((v1) -> {
            StudentDAO studentDAO = new StudentDAO(viewGroup.getContext());
            studentDAO.delete(getItem(i));// xoa sinh vien trong csdl
            danhSach.remove(i); // xoa sinh vien trong mang
            notifyDataSetChanged(); // cap nhat len giao dien
        });
        btnUpdate.setOnClickListener((v1) -> {
            StudentDAO studentDAO = new StudentDAO(viewGroup.getContext());
            String name = " ten moi";
            String phone = " phone moi";
            getItem(i).setName(name);
            getItem(i).setPhone(phone);
            studentDAO.update(getItem(i));
            notifyDataSetChanged(); // cap nhat du lieu
        });
        Student student = getItem(i);
        tvName.setText(student.getName());
        tvPhone.setText(student.getPhone());
        // cách gán gía trị đơn giản nhưng chưa tối ưu cho ListView
        return view;
    }
}
