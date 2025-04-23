package com.example;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private School school;
    public static final String ROJO = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {


        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please, enter a name for the new school: ");
        String schoolName = myScanner.nextLine();
        var school = new School(schoolName);


        System.out.println("Now, we need some "+ROJO+"TEACHER/S"+ RESET +" for your school " + schoolName + ". How wany teachers should be created? Please enter a number.");

        int numberOfTeachers = 0;
        boolean validInput = false;

        while (!validInput) {
            String input = myScanner.nextLine();
            try {
                numberOfTeachers = Integer.parseInt(input);
                if (numberOfTeachers < 0) {
                    System.out.println("The number of teachers cannot be negative. Please enter a valid positive integer.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid whole number (e.g., 3) for the number of teachers.");
            }
        }



        for (int i = 0; i < numberOfTeachers; i++) {
            System.out.println("\nEnter the details for teacher " + (i+1));

            System.out.println("Name: ");
            String name = myScanner.nextLine();

            double salary = 0.0;
            boolean validSalary = false;

            while (!validSalary) {
                System.out.println("Salary: ");
                String salaryInput = myScanner.nextLine();

                try {

                    salary = Double.parseDouble(salaryInput);

                    if (salary <= 0) {
                        System.out.println("Salary must be a positive number greater than 0. Please try again.");
                    } else {
                        validSalary = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number (e.g., 199.99 or 150) for the price.");
                }

            }

            Teacher teacher = new Teacher(name, salary);
            school.addTeacher(teacher);

            System.out.println("Teacher " + (i+1) + " added.");
        }
        System.out.println(numberOfTeachers + "teachers created for " + schoolName);

        System.out.println("Now, we need some "+ROJO+"COURSE/S"+ RESET + " How wany should be created? Please enter a number.");
        int numberOfCourses = 0;
        boolean validInput2 = false;

        while (!validInput2) {
            String input = myScanner.nextLine();
            try {
                numberOfCourses = Integer.parseInt(input);
                if (numberOfCourses < 0) {
                    System.out.println("The number of courses cannot be negative. Please enter a valid positive integer.");
                } else {
                    validInput2 = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid whole number (e.g., 3) for the number of courses.");
            }
        }


        for (int i = 0; i < numberOfCourses; i++) {
            System.out.println("\nEnter the details for course " + (i+1));

            System.out.println("Name: ");
            String name = myScanner.nextLine();

            double price = 0.0;
            boolean validPrice = false;

            while (!validPrice) {
                System.out.println("Price: ");
                String priceInput = myScanner.nextLine();

                try {
                    price = Double.parseDouble(priceInput);

                    if (price <= 0) {
                        System.out.println("Price must be a positive number greater than 0. Please try again.");
                    } else {
                        validPrice = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number (e.g., 199.99 or 150) for the price.");
                }
            }

            Course course = new Course(name, price);
            school.addCourse(course);

            System.out.println("Course " + (i+1) + " added.");
        }
        System.out.println(numberOfCourses + "courses created for " + schoolName);

        System.out.println("Let's create the "+ROJO+"STUDENTS/S"+RESET+". How many should be created? Please enter a number.");
        int numberOfStudents = 0;
        boolean validInput3 = false;

        while (!validInput3) {
            String input = myScanner.nextLine();
            try {
                numberOfStudents = Integer.parseInt(input);
                if (numberOfStudents < 0) {
                    System.out.println("The number of students cannot be negative. Please enter a valid positive integer.");
                } else {
                    validInput3 = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid whole number (e.g., 3) for the number of students.");
            }
        }


        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nEnter the details for student " + (i+1));

            System.out.println("Name: ");
            String name = myScanner.nextLine();

            System.out.println("Address: ");
            String address = myScanner.nextLine();

            System.out.println("Email: ");
            String email = myScanner.nextLine();

            Student student = new Student(name, address, email);
            school.addStudent(student);

            System.out.println("Student " + (i+1) + " added.");
        }
        System.out.println(numberOfStudents + "students created for " + schoolName);

        //comandos
        boolean continueRunning = true;
        while (continueRunning) {
            System.out.println("Enter a command from the next list: \n ENROLL [STUDENT_ID] [COURSE_ID] \n ASSIGN [TEACHER_ID] [COURSE_ID] \n SHOW COURSES \n LOOKUP COURSE [COURSE_ID] \n SHOW STUDENTS \n LOOKUP STUDENT [STUDENT_ID] \n SHOW TEACHERS \n LOOKUP TEACHER [TEACHER_ID] \n SHOW PROFIT ");
            var input = myScanner.nextLine().toUpperCase();

            CommandHandler commandHandler = new CommandHandler (school.getStudents(), school.getCourses(), school.getTeachers());
            boolean validCommand = commandHandler.executeCommand(input);
            if (!validCommand) {
                System.out.println("Press any key to try it again...");
                myScanner.nextLine(); // Espera que el usuario pulse algo
                continue; // vuelve al principio del while
            }


        }
    }
}