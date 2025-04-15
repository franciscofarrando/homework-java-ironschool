package com.example;

import java.util.UUID;

public class Teacher {
    private String teacherId; //UUID
    private String name;
    private double salary;
    private Course course;

    public Teacher (String name, double salary) {
        setName(name);
        setSalary(salary);
    }
    public Teacher(){
        this.teacherId = UUID.randomUUID().toString();
    }

    public String getTeacherId() {
        return teacherId;
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
        this.salary = salary;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
