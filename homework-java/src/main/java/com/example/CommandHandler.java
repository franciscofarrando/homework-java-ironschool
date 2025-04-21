package com.example;
import java.util.*;

public class CommandHandler {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;

    public CommandHandler(List<Student> students, List<Course> courses, List<Teacher> teachers) {
        this.students = students;
        this.courses = courses;
        this.teachers = teachers;
    }

    public void executeCommand(String wholeCommand){
        String[] commandPart = wholeCommand.split(" ");
        String command = commandPart[0];
        switch (command){
            case "ENROLL":
               enrollStudent(commandPart[1],commandPart[2]);
               break;
            case "ASSIGN":

                break;
            case "SHOW":
                handleShow(commandPart);
                break;
            case "LOOKUP":
                lookUp(commandPart);
                break;
            default:
                System.out.println("Can't recognize command");

        }
    }

    public Student findStudentById(String student_id){
        Student student = null;
        for(Student s: students){
            if(s.getStudentId().equals(student_id)){
                student = s;
                return student;
            }
        }
        return null;
    }

    public Course findCourseById(String course_id){
        Course course = null;
        for(Course c: courses){
            if(c.getCourseId().equals(course_id)){
                course = c;
                return course;
            }
        }
        return null;
    }

    public Teacher findTeacherById(String teacher_id){
        Teacher teacher = null;
        for(Teacher t: teachers){
            if(t.getTeacherId().equals(teacher_id)){
                teacher = t;
                return teacher;
            }
        }
        return null;
    }

    private void lookUp(String[] commandPart) {
        switch (commandPart[1]){
            case "COURSE":
                break;
            case "STUDENT":
                break;
            case "TEACHER":
                System.out.println(findTeacherById(commandPart[2]).toString());
        }

    }

    private void enrollStudent(String student_id, String course_id) {
        Student student =  findStudentById(student_id);
        Course course =  findCourseById(course_id);

         if (student != null && course!= null) {
             student.setCourse(course);
             updateMoneyEarned(course);
         } else {
             System.out.println("Couldn't assign the course");
         }

    }

    private void updateMoneyEarned(Course course){
        double total = course.getMoney_earned() + course.getPrice();
        course.setMoney_earned(total);
    }

    private void handleShow(String[] command) {
        switch (command[0]){
            case "COURSES":
                showCourses();
            case "STUDENTS":
                showStudents();
            case "TEACHERS":
                showTeachers();
            case "PROFIT":
                showProfit();
            default:
                System.out.println( "Can't recognize command");
        }
    }

    private void showStudents() {
        StringBuilder studentsString = new StringBuilder();
        for (Student student: students){
            studentsString.append(student.toString()).append("\n");
        }
        System.out.println(studentsString);
    }

    private void showTeachers() {
        StringBuilder teachersString = new StringBuilder();
        for (Teacher teacher: teachers){
            teachersString.append(teacher.toString()).append("\n");
        }
        System.out.println(teachersString);
    }

    private void showProfit() {

    }

    private void showCourses() {
        StringBuilder coursesString = new StringBuilder();
        for (Course course: courses){
            coursesString.append(course.toString()).append("\n");
        }
        System.out.println(coursesString);
    }


}
