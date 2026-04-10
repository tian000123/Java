package com.hbsd.day03;

public class Method02 {
    public static double count(String grade,double price){
        double sum_price = 0.0;
        switch (grade){
            case "common":
                sum_price = (double)price;
                break;
            case  "VIP":
                sum_price = (double) price * 0.9;
                break;
            case  "SVIP":
                sum_price = (double) price * 0.8;
                break;
        }
        return sum_price;
    }

    public static void main(String[] args) {
        System.out.println(count("VIP", 1000));
    }
}
