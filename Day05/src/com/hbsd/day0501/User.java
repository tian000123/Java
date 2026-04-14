package com.hbsd.day0501;

public class User {
    private String name;
    private int age;
    private String department;

    public User() {
    }

    public User(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0 && age < 120){
            this.age = age;
        }
        else{
            System.out.println("年龄设置错误，必须在0-120岁之间");
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
