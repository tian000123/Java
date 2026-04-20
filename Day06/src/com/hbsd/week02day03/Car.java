package com.hbsd.week02day03;

public class Car {
    String number;
    double price;

    public Car() {
    }

    public Car(String number, double price) {
        this.number = number;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double money(double miles){
        double finalPrice = 0.0;
        if(miles <= 3.0){
            finalPrice += price;
        }
        else if(miles > 3.0){
            finalPrice = price + (miles - 3) * 2;
        }
        return finalPrice;
    }
}
