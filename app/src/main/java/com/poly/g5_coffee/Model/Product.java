package com.poly.g5_coffee.Model;

import java.io.Serializable;

public class Product implements Serializable {
    public int id;
    public String nameSp;
    public int price;
    public int soluong;
    public String message;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSp() {
        return nameSp;
    }

    public void setNameSp(String nameSp) {
        this.nameSp = nameSp;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameSp='" + nameSp + '\'' +
                ", price=" + price +
                ", soluong=" + soluong +
                ", message='" + message + '\'' +
                '}';
    }
}
