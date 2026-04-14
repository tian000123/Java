package com.hbsd.day0501;

public class Wage {
    private String name;
    private double salary;

    public Wage() {
    }

    public Wage(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary < 2000){
            this.salary = 0;
            System.out.println("底薪必须大于2000元！");
        }
        else{
            this.salary = salary;
        }
    }


    public boolean adjustSalary(double reduceSalary){
//        double newSalary = this.salary - reduceSalary;

        double maxReduceSalary = this.salary * 0.5;

        if(reduceSalary > maxReduceSalary){
            System.out.println("您尝试的降薪金额为:" + reduceSalary);
            System.out.println("最大降薪金额为:" + maxReduceSalary);
            System.out.println("降薪失败");
            return false;
        }
        else{
            double newSalary = salary - reduceSalary;
            return true;
        }
    }
}
