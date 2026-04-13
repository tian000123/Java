package com.hbsd.day04;

public class Student {
    private String studentId;
    private int age;
    private String name;

    public Student() {
    }

    public Student(String studentId, int age, String name) {
        this.studentId = studentId;
        this.age = age;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
