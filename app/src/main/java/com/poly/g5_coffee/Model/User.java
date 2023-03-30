package com.poly.g5_coffee.Model;

public class User {
    private  int id;
    private String name;
    private int phoneNumber;
    private String diaChi;

    public User() {
    }

    public User(int id, String name, int phoneNumber, String diaChi) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.diaChi = diaChi;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
