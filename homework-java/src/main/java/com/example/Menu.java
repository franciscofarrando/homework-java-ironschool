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

        for (int i = 0; i < numberOfTeachers; i++) {
            System.out.println("\nEnter the details for teacher " + (i+1));

            System.out.println("Name: ");
            String name = myScanner.nextLine();

            System.out.println("Salary: ");
            double salary = Double.parseDouble(myScanner.nextLine());

            Teacher teacher = new Teacher(name, salary);
            school.addTeacher(teacher);

            System.out.println("Teacher " + (i+1) + " added.");
        }
        System.out.println(numberOfTeachers + "teachers created for " + schoolName);

        System.out.println("Now, we need some courses. How wany should be created? Please enter a number.");
        int numberOfCourses = Integer.parseInt(myScanner.nextLine());

        for (int i = 0; i < numberOfCourses; i++) {
            System.out.println("\nEnter the details for course " + (i+1));

            System.out.println("Name: ");
            String name = myScanner.nextLine();

            System.out.println("Price: ");
            double price = Double.parseDouble(myScanner.nextLine());

            Course course = new Course(name, price);
            school.addCourse(course);

            System.out.println("Course " + (i+1) + " added.");
        }
        System.out.println(numberOfCourses + "courses created for " + schoolName);

        System.out.println("Let's create the students. How many should be created? Please enter a number.");
        int numberOfStudents = Integer.parseInt(myScanner.nextLine());

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
            var input = myScanner.nextLine();

            CommandHandler commandHandler = new CommandHandler (school.getStudents(), school.getCourses(), school.getTeachers());
            commandHandler.executeCommand(input);

            System.out.println("Do you want to perform another action? (yes/no)");
            String response = myScanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                continueRunning = false;
                System.out.println("Thank you for using the School Manager. Goodbye!");
            }


        }
    }
}