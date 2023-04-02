package com.poly.g5_coffee.Model;

public class User {
    public  int id;
    public String name;
    public String phoneNumber;
    public String diaChi;
    public String userName;
    public String password;

    public User() {
    }

    public User(int id, String name, String phoneNumber, String diaChi, String userName, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.diaChi = diaChi;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
