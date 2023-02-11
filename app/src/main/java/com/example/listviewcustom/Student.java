package com.example.listviewcustom;

public class Student {

    private String name;
    private String phone;
    private int id;

    public Student(String name, String phone, int id) {
        this.name = name;
        this.phone = phone;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    private int avatar = R.mipmap.ic_launcher;

    public Student(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
