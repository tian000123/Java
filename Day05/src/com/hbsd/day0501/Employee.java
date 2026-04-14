package com.hbsd.day0501;

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
        this.baseSalary = baseSalary;
    }

    public static void printInfo(String id,String name,double baseSalary){
        System.out.println("员工的id为：" + id);
        System.out.println("员工的名字为：" + name);
        System.out.println("员工的底薪为：" + baseSalary);
    }
}
