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

        System.out.println("Let's create the students. How many should be created? Please enter a number.");
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
        boolean continueRunning = true;
        while (continueRunning) {
            System.out.println("Enter a command from the next list: \n ENROLL [STUDENT_ID] [COURSE_ID] \n ASSIGN [TEACHER_ID] [COURSE_ID] \n SHOW COURSES \n LOOKUP COURSE [COURSE_ID] \n SHOW STUDENTS \n LOOKUP STUDENT [STUDENT_ID] \n SHOW TEACHERS \n LOOKUP TEACHER [TEACHER_ID] \n SHOW PROFIT ");
            var input = myScanner.nextLine();

            commandHandler.executeCommand(input);


            /*String[] parts = input.split(" ");

            if (parts[0].equalsIgnoreCase("ENROLL") && parts.length == 3) {
                commandHandler.enrollStudent(parts[1], parts[2]);
            } else if (parts[0].equalsIgnoreCase("ENROLL")) {
                System.out.println("ENROLL command needs to follow this format: ENROLL [STUDENT_ID] [COURSE_ID]");
            }

            if (parts[0].equalsIgnoreCase("ASSIGN") && parts.length == 3) {
               // commandHandler.??(parts[1], parts[2]);
            } else if (parts[0].equalsIgnoreCase("ASSIGN")) {
                System.out.println("ENROLL command needs to follow this format: [TEACHER_ID] [COURSE_ID]");
            }

            if (parts[0].equalsIgnoreCase("SHOW") && parts.length == 2 && parts[1].equalsIgnoreCase("COURSES")) {
                commandHandler.handleShow();
            }

            if (parts[0].equalsIgnoreCase("LOOKUP") && parts[1].equalsIgnoreCase("COURSE") && parts.length == 3) {
                commandHandler.findCourseById(parts[2]);
            } else if (parts[0].equalsIgnoreCase("LOOKUP") && parts[1].equalsIgnoreCase("COURSE")) {
                System.out.println("LOOKUP COURSE command needs to follow this format: LOOKUP COURSE [COURSE_ID]");
            }

            if (parts[0].equalsIgnoreCase("SHOW") && parts.length == 2 && parts[1].equalsIgnoreCase("STUDENTS")) {
               // commandHandler.enrollStudent();
            }

            if (parts[0].equalsIgnoreCase("LOOKUP") && parts[1].equalsIgnoreCase("STUDENT") && parts.length == 3) {
                commandHandler.findStudentById(parts[2]);
            } else if (parts[0].equalsIgnoreCase("LOOKUP") && parts[1].equalsIgnoreCase("STUDENT")) {
                System.out.println("LOOKUP STUDENT command needs to follow this format: LOOKUP STUDENT [STUDENT_ID]");
            }

            if (parts[0].equalsIgnoreCase("SHOW") && parts.length == 2 && parts[1].equalsIgnoreCase("TEACHERS")) {
                //commandHandler.enrollStudent();
            }

            if (parts[0].equalsIgnoreCase("LOOKUP") && parts[1].equalsIgnoreCase("TEACHER") && parts.length == 3) {
                //commandHandler.enrollStudent(parts[2]);
            } else if (parts[0].equalsIgnoreCase("LOOKUP") && parts[1].equalsIgnoreCase("TEACHER")) {
                System.out.println("LOOKUP TEACHER command needs to follow this format: LOOKUP TEACHER [TEACHER_ID]");
            }

            if (parts[0].equalsIgnoreCase("SHOW") && parts.length == 2 && parts[1].equalsIgnoreCase("PROFIT")) {
                //commandHandler.enrollStudent();
            }

             */
            System.out.println("Do you want to perform another action? (yes/no)");
            String response = myScanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                continueRunning = false;
                System.out.println("Thank you for using the School Manager. Goodbye!");
            }


        }
    }
}