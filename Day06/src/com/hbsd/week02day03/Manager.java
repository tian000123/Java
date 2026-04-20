package com.hbsd.week02day03;

public class Manager extends Employee {
    private double bonus;  // 奖金

    public Manager() {
        super();
    }

    public Manager(String id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // 重写 calculateSalary 方法（经理薪资 = 底薪 + 奖金）
    @Override
    public double calculateSalary() {
        return super.getBaseSalary() + bonus;
    }

    // 重写打印方法
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("奖金：" + bonus);
        System.out.println("总薪资：" + calculateSalary());
    }
}