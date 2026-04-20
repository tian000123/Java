package com.hbsd.week02day03;  // 统一包名

public class Employee {
    private String id;
    private String name;
    private double baseSalary;

    public Employee() {
    }

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 2000) {
            this.baseSalary = baseSalary;
        } else {
            System.out.println("底薪不能低于2000，已设置为2000");
            this.baseSalary = 2000;
        }
    }

    // 计算薪资的方法（父类版本，子类需要重写）
    public double calculateSalary() {
        return baseSalary;
    }

    // 打印信息的方法
    public void printInfo() {
        System.out.println("工号：" + id);
        System.out.println("姓名：" + name);
        System.out.println("底薪：" + baseSalary);
    }

    @Override
    public String toString() {
        return "Employee{id='" + id + "', name='" + name + "', baseSalary=" + baseSalary + "}";
    }
}