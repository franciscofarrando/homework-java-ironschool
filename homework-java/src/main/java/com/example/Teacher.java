package com.example;

import java.util.*;

public class Teacher {
    private String teacherId;
    private String name;
    private double salary;


    public Teacher (String name, double salary) {
        this.teacherId = generateUniqueTeacherId();
        setName(name);
        setSalary(salary);
    }
    public Teacher(){
        this.teacherId = generateUniqueTeacherId();
    }
    private static final Set<String> usedIds = new HashSet<>();
    private String generateUniqueTeacherId() {
        String id;
        Random random = new Random();
        do {
            int number = random.nextInt(900) + 100; // genera número entre 100 y 999
            id = "S" + number;
        } while (usedIds.contains(id));

        usedIds.add(id);
        return id;
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

    @Override
    public String toString() {
        return String.format(
                "👨‍🏫 Teacher Info:\n" +
                        "📛 Name       : %s\n" +
                        "🆔 ID         : %s\n" +
                        "💰 Salary     : $%.2f",
                name, teacherId, salary
        );
    }

    public void setCourse(Course course) {
    }
}
