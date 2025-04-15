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
               enrollStudent(commandPart[0],commandPart[1]);
               break;
            case "ASSIGN":
                assignTeacher(commandPart[0], commandPart[1]);
                break;
            case "SHOW":
                handleShow(commandPart);
                break;
            case "LOOKUP":
                handleLookUp(commandPart);
                break;
            default:
                System.out.println("Can't recognize command");

        }
    }
// buscadores de ID

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


    private void enrollStudent(String student_id, String course_id) {
        Student student =  findStudentById(student_id);
        Course course =  findCourseById(course_id);

         if (student != null && course!= null) {
             student.setCourse(course);
         } else {
             System.out.println("Couldn't assign the course");
         }
        assert course != null;
        updateMoneyEarned(course);
    }

    public void assignTeacher(String teacher_id, String course_id){
        Teacher teacher = findTeacherById(teacher_id);
        Course course = findCourseById(course_id);

        if (teacher != null && course!=null){
            teacher.setCourse(course);
        }else {
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
                break;
            case "STUDENTS":
                showStudents();
                break;
            case "TEACHERS":
                showTeachers();
                break;
            case "PROFIT":
                showProfits();
                break;
        }
    }

    private void showCourses() {
        for (Course course: courses){
        System.out.println(course.toString());
        }
    }

    private void showStudents() {
        for (Student student: students){
            System.out.println(student.toString());
        }
    }

    private void showTeachers() {
        for (Teacher teacher: teachers){
            System.out.println(teacher.toString());
        }
    }

    private void showProfits() {
        double totalEarned = courses.stream().mapToDouble(courses ->courses.getMoney_earned()).sum();
        double totalSalaries = teachers.stream().mapToDouble(teachers -> teachers.getSalary()).sum();

        System.out.println("Profits are: " + (totalEarned-totalSalaries));
    }



    private void handleLookUp(String[] command) {
        String id = command[1];
        switch (command[0]){
            case "COURSE":
                lookUpCourse(id);
                break;
            case "STUDENT":
                lookUpStudent(id);
                break;
            case "TEACHER":
                lookUpTeacher(id);
                break;
            default:
                System.out.println("Can't recognize command");

        }
    }

    private void lookUpCourse(String id) {
        Course course = findCourseById(id);
        if(course != null){
            System.out.println(id);
        }else {
            System.out.println("Course not found.");
        }


    }
    private void lookUpStudent(String id) {
        Student student = findStudentById(id);
        if(student != null){
            System.out.println(id);
        }else {
            System.out.println("Student not found.");
        }
    }
    private void lookUpTeacher(String id) {
        Teacher teacher = findTeacherById(id);
        if (teacher!=null){
            System.out.println(id);
        }else {
            System.out.println("Teacher not found");
        }
    }
}
