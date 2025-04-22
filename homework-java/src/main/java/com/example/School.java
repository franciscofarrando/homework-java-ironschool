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


    public void addCourse (Course course){
        courses.add(course);
    }
    public List<Course> getCourses () {
        return courses;
    }


    public void addStudent (Student student){
        students.add(student);
    }
    public List<Student> getStudents () {
        return students;
    }

}

