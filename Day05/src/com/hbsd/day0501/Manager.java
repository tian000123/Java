package com.hbsd.day0501;

public class Manager extends Employee{
    private double bonus;

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

    @Override
    public double getBaseSalary(){
        return super.getBaseSalary() + bonus;
    }


}
