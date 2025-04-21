package com.example;
import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Course> courses;

    public School(String name) {
        this.name = name;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }
    public void addTeacher (Teacher teacher){
            teachers.add(teacher);
    }
    public List<Teacher> getTeachers () {
            return teachers;
    }

    /*public void showTeachers() {
            if (teachers.isEmpty()) {
                System.out.println("No teachers have been added yet.");
            } else {
                System.out.println("\n Teachers at " + name + ":");
                for (int i = 0; i < teachers.size(); i++) {
                    System.out.println(" #" + (i + 1) + " - " + teachers.get(i));
                }
            }
    }*/
    public void addCourse (Course course){
        courses.add(course);
    }
    public List<Course> getCourses () {
        return courses;
    }

    /*public void showCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses have been added yet.");
        } else {
            System.out.println("\n Courses at " + name + ":");
            for (int i = 0; i < courses.size(); i++) {
                System.out.println(" #" + (i + 1) + " - " + courses.get(i));
            }
        }
    }*/
    public void addStudent (Student student){
        students.add(student);
    }
    public List<Student> getStudents () {
        return students;
    }
    /*
    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("No students have been added yet.");
        } else {
            System.out.println("\n Students at " + name + ":");
            for (int i = 0; i < students.size(); i++) {
                System.out.println(" #" + (i + 1) + " - " + students.get(i));
            }
        }
    }*/
}

