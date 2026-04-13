package com.hbsd.day04;

public class ExceptionDemo {

        public static void main(String[] args) {
            User user3 = null;
            try{
                String name = user3.userName;

            }catch(NullPointerException e){
                System.out.println("捕获到异常：" + e.getMessage());
            }
        }

    }

