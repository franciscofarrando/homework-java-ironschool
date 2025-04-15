package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {


        Scanner myScanner = new Scanner(System.in);

        public void CreatingSchool () {
            System.out.println("Please, enter a name for the new school: ");
            String schoolName = myScanner.nextLine();
            //hay que crear la clase School?

            System.out.println("Now, we need some teachers for your school " + schoolName + ". How wany teachers should be created? Please enter a number.");
            int numberOfTeachers = myScanner.nextInt();
            myScanner.nextLine();

            List<Teacher> teachers = new ArrayList<>();

            for (int i = 0; i < numberOfTeachers; i++) {
                System.out.println("\nEnter the details for teacher " + i);

                System.out.println("Name: ");
                String name = myScanner.nextLine();

                System.out.println("Salary: ");
                double salary = myScanner.nextDouble();
                myScanner.nextLine();

                Teacher teacher = new Teacher(name, salary);
                teachers.add(teacher);

                System.out.println("Teacher " + i + "added.");
            }
            System.out.println(numberOfTeachers + "teachers created for " + schoolName);


        }
    }
