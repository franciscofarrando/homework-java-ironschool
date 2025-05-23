package com.example;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class Course {
    private static final Set<String> usedIds = new HashSet<>();

    private String courseId;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;

    //constructor de name y price
    public Course(String name, double price) {
        this.courseId = generateUniqueCourseId();
        this.name = name;
        this.price = price;
    }
    //Constructor vacio con id

    public Course() {
        this.courseId = generateUniqueCourseId();
    }

    private String generateUniqueCourseId() {
        String id;
        Random random = new Random();
        do {
            int number = random.nextInt(900) + 100;
            id = "C" + number;
        } while (usedIds.contains(id));

        usedIds.add(id);
        return id;
    }

    //getters y setters

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

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public double getMoney_earned() {
        return money_earned;
    }

    public void setMoney_earned(double money_earned) {
        this.money_earned = money_earned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    @Override
    public String toString() {
        return String.format(
                "📚 Course Info:\n" +
                        "🔢 ID            : %s\n" +
                        "📖 Name          : %s\n" +
                        "💵 Price         : $%.2f\n" +
                        "💰 Money Earned  : $%.2f\n" +
                        "👨‍🏫 Teacher      : %s",
                courseId, name, price, money_earned, teacher
        );
    }
}
