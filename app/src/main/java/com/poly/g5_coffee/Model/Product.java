package com.poly.g5_coffee.Model;

public class Product {
    private int id;
    private String nameSp;
    private int price;
    private int soluong;
    private String message;

    public Product() {
    }

    public Product(int id, String nameSp, int price, int soluong, String message) {
        this.id = id;
        this.nameSp = nameSp;
        this.price = price;
        this.soluong = soluong;
        this.message = message;
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
