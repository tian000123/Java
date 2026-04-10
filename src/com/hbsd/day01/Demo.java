package com.hbsd.day01;

public class Demo {
    public static void main(String[] args) {
        // 电商结算中心 购物车结算程序
        String[] goods = {"手机", "电脑", "键盘", "鼠标", "音箱"};
        int[] price = {1000, 5000, 100, 50, 300};

        //计算购物车价格

        // 定义购物车

        String[] shopping = {"手机", "电脑", "键盘"};
        int sum_price = 0;
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 5;j++){
                if(shopping[i].equals(goods[j])){
                    sum_price += price[j];
                }
            }
        }
        System.out.println("原价：" + sum_price);

        //单品满减计算
        // 满减规则：满100减10 满 500减50 满1000减100
        if(sum_price >= 100 && sum_price < 500){
            sum_price -= 10;
        }
        else if(sum_price >= 500 && sum_price < 1000){
            sum_price -= 50;
        }
        else if(sum_price >= 1000){
            sum_price -= 100;
        }


        boolean isVip = true;

        // VIP折扣结算
        double count_price = 0.0;
        if(isVip == true){
            count_price = sum_price * 0.9;
        }
        else{
            count_price = sum_price;
        }
        System.out.println("打折后的价格：" + count_price);

    }
}
