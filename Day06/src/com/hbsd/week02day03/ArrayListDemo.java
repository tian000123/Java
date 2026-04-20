package com.hbsd.week02day03;


import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> studentList = new ArrayList<>();

        studentList.add("张三");
        studentList.add("李四");
        studentList.add("王五");

        studentList.add(2,"赵六");

        studentList.add("孙琪");
        studentList.add("周八");
        studentList.add("钱一");
        studentList.add("王三");
        studentList.add("刘六");

        System.out.println(studentList.get(3));

        studentList.indexOf("李四");
        System.out.println(studentList.indexOf("李四"));
        System.out.println(studentList);
        studentList.set(1,"李小四");

        studentList.remove("李小四");
        System.out.println(studentList);

        System.out.println(studentList.indexOf("张三"));
        studentList.remove(0);
        System.out.println(studentList);

        System.out.println(studentList.contains("李小四"));

        studentList.clear();
        System.out.println(studentList);




    }
}
