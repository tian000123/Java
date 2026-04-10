package com.hbsd.day03;

public class Method02 {
    public static void main(String[] args) {
        int[] num1 = {2, 3, 4, 5, 6};
        int num[] = {1, 2, 3, 4, 5};

        hhh(num1);
        hhh(num);
    }
    public static void hhh(int num[]){
        for(int i : num){
            System.out.println(i);
        }
    }
}
