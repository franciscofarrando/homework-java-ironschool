package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
     private School school;

    public static void main(String[] args) {


        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please, enter a name for the new school: ");
        String schoolName = myScanner.nextLine();
        var school = new School(schoolName);


        System.out.println("Now, we need some teachers for your school " + schoolName + ". How wany teachers should be created? Please enter a number.");
        int numberOfTeachers = Integer.parseInt(myScanner.nextLine());

        for (int i = 1; i < numberOfTeachers; i++) {
                System.out.println("\nEnter the details for teacher " + i);

                System.out.println("Name: ");
                String name = myScanner.nextLine();

                System.out.println("Salary: ");
                double salary = Double.parseDouble(myScanner.nextLine());

                Teacher teacher = new Teacher(name, salary);
                school.addTeacher(teacher);

                System.out.println("Teacher " + i + " added.");
            }
        System.out.println(numberOfTeachers + "teachers created for " + schoolName);

        System.out.println("Now, we need some courses. How wany should be created? Please enter a number.");
        int numberOfCourses = Integer.parseInt(myScanner.nextLine());

        for (int i = 1; i < numberOfCourses; i++) {
            System.out.println("\nEnter the details for course " + i);

            System.out.println("Name: ");
            String name = myScanner.nextLine();

            System.out.println("Price: ");
            double price = Double.parseDouble(myScanner.nextLine());

            Course course = new Course(name, price);
            school.addCourse(course);

            System.out.println("Course " + i + " added.");
        }
        System.out.println(numberOfCourses + "courses created for " + schoolName);

        System.out.println("Let's create the students. How wany should be created? Please enter a number.");
        int numberOfStudents = Integer.parseInt(myScanner.nextLine());

        for (int i = 1; i < numberOfStudents; i++) {
            System.out.println("\nEnter the details for student " + i);

            System.out.println("Name: ");
            String name = myScanner.nextLine();

            System.out.println("Address: ");
            String address = myScanner.nextLine();

            System.out.println("Email: ");
            String email = myScanner.nextLine();

            Student student = new Student(name, address, email);
            school.addStudent(student);

            System.out.println("Student " + i + " added.");
        }
        System.out.println(numberOfStudents + "students created for " + schoolName);

        //comandos
         while(true) {
             System.out.println("Enter a command from the next list: ");
             var input = myScanner.nextLine();
             String [] parts = input.split(" ");
             if(parts[0].equalsIgnoreCase("Enroll")&& parts.length == 3) {
                // school.enrollStudent(parts[1], parts[2]);
             } else {
                 //System.out.println("ENROLL command needs to follow this format: ENOLL [sadlf]");
             }

             break;
         }


        }
    }
