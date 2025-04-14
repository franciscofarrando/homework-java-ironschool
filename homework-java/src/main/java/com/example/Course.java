package com.example;

public class CourseClass {
    private String courseId;
    private String name;
    private double price;
    private double money_earned;
    // private Teacher teacher;

    //constructor de name y price


    public CourseClass(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CourseClass{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", money_earned=" + money_earned +
                '}';
    }
}
