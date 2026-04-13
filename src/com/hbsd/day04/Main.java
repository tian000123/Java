package com.hbsd.day04;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();

        user1.userName = "张三";
        user1.age = 20;
        user1.email = "235@qq.com";
        user1.gender = "男";

        System.out.println("姓名：" + user1.userName);
        System.out.println("年龄：" + user1.age);
        System.out.println("邮箱：" + user1.email);
        System.out.println("性别：" + user1.gender);

        user2.userName = "李四";
        user2.age = 19;
        user2.email = "233@qq.com";
        user2.gender = "女";

        System.out.println("姓名：" + user2.userName);
        System.out.println("年龄：" + user2.age);
        System.out.println("邮箱：" + user2.email);
        System.out.println("性别：" + user2.gender);

        user1.userName = "张三丰";

        System.out.println("修改后user1的姓名：" + user1.userName);
        System.out.println("修改后user2的姓名：" + user2.userName);


    }
}
