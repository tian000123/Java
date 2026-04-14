package com.hbsd.day0501;

public class Manager extends Employee{
    private double bouns;

    public Manager() {
        super();
    }

    public Manager(String id, String name, double baseSalary, double bouns) {
        super(id, name, baseSalary);
        this.bouns = bouns;
    }

    public double getBouns() {
        return bouns;
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }

    @Override
    public double getBaseSalary(){
        return super.getBaseSalary() + bouns;
    }


}
