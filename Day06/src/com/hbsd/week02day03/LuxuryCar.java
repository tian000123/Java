package com.hbsd.week02day03;

public class LuxuryCar extends Car{

    public LuxuryCar() {
        super();
    }

    public LuxuryCar(String number, double price) {
        super(number, price);
    }

    @Override
    public double money(double miles){
        double finalPrice = super.money(miles) * 1.3;
        return finalPrice;
    }
}
