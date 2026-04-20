package com.hbsd.week02day03;

public class SalaryEngineMain {
    public static void main(String[] args) {
        // 创建员工数组（长度3）
        Employee[] staff = new Employee[3];

        // 普通员工
        staff[0] = new Employee("E001", "张三", 4000);

        // 经理
        staff[1] = new Manager("M001", "刘总", 15000, 8000);

        // 销售员（注意索引是2，不是3）
        staff[2] = new Salesman("S001", "王牌", 3000, 200000, 0.05);

        // 遍历并输出每个人的薪资
        System.out.println("=== 员工薪资列表 ===");
        for (Employee e : staff) {
            System.out.println(e.getName() + " 的薪资为：" + e.calculateSalary());
        }

        System.out.println();
        System.out.println("=== 员工详细信息 ===");
        for (Employee e : staff) {
            e.printInfo();
            System.out.println();
        }
    }
}