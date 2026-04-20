package com.hbsd.week02day03;

public class Salesman extends Employee {
    private double salesVolume;  // 销售额
    private double commissionRate;  // 提成比例

    public Salesman() {
        super();
    }

    public Salesman(String id, String name, double baseSalary, double salesVolume, double commissionRate) {
        super(id, name, baseSalary);
        this.salesVolume = salesVolume;
        this.commissionRate = commissionRate;
    }

    public double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(double salesVolume) {
        this.salesVolume = salesVolume;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    // 重写 calculateSalary 方法（销售员薪资 = 底薪 + 销售额 × 提成比例）
    @Override
    public double calculateSalary() {
        return super.getBaseSalary() + (salesVolume * commissionRate);
    }

    // 重写打印方法
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("销售额：" + salesVolume);
        System.out.println("提成比例：" + (commissionRate * 100) + "%");
        System.out.println("总薪资：" + calculateSalary());
    }
}