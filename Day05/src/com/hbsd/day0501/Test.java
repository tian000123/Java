package com.hbsd.day0501;

public class Test {
    public static void main(String[] args) {
        User user1 = new User("张三",0,"后端");
        System.out.println("user1的姓名：" + user1.getName());
        System.out.println("user1的年龄:" + user1.getAge());
        System.out.println("user1的部门:" + user1.getDepartment());

        Employee user2 = new Employee("001","张三",3000);

    }
}
