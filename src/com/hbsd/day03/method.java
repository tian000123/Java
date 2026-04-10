package com.hbsd.day03;

public class method {
    // main实现 基础运算
    // 1.加减 2. 平均值 3.奇偶判断、4.最大值 5.闰年判断
    public static int sum(int a,int b){
        return a + b;
    }
    public static int sub(int a,int b){
        return a - b;
    }
    public static int mul(int a,int b){
        return a * b;
    }
    public static double divide(double a,double b){
        return  a / b;
    }
    public static double aver(int [] num){
        int sum = 0;
        for(int i = 0; i < num.length;i++){
            sum += num[i];
        }
        return (double) sum / num.length;
    }
    public static boolean isEven(int a){
        if(a % 2 == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public static int max(int[] num){
        int max = num[0];
        for(int i = 0;i < num.length;i++){
            if(max < num[i]){
                max = num[i];
            }
        }
        return max;
    }
    public static boolean isLeapYear(int year){
        if(year % 400 == 0){
            return true;
        }
        else if(year % 100 == 0){
            return false;
        }
        else if(year % 4 == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        int sum = sum(10, 20);

    }
}
