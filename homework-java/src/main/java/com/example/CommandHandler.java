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

    public boolean executeCommand(String wholeCommand){
        String[] commandPart = wholeCommand.split(" ");
        if (commandPart.length == 0) {
            System.out.println("❌ Comando vacío.");
            return false;
        }
        String command = commandPart[0].toUpperCase();

        switch (command){
            case "ENROLL":
               enrollStudent(commandPart[1],commandPart[2]);
                return true;
            case "ASSIGN":
                assignTeacher(commandPart[1],commandPart[2]);
                return true;
            case "SHOW":
                //System.out.println(command);
                handleShow(commandPart);
                return true;
            case "LOOKUP":
                lookUp(commandPart);
                return true;
            default:
                System.out.println("❌ Comando no reconocido.");
                return false;
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
                Course course = findCourseById(commandPart[2]);
                if (course != null)
                    System.out.println(course.toString());
                else
                    System.out.println("Course not found.");
                break;
            case "STUDENT":
                Student student = findStudentById(commandPart[2]);
                if (student != null)
                    System.out.println(student.toString());
                else
                    System.out.println("Student not found.");
                break;
            case "TEACHER":
                Teacher teacher = findTeacherById(commandPart[2]);
                if (teacher != null)
                    System.out.println(teacher.toString());
                else
                    System.out.println("Teacher not found.");
                break;
        }
    }

    private void enrollStudent(String student_id, String course_id) {
        Student student =  findStudentById(student_id);
        Course course =  findCourseById(course_id);

         if (student != null && course!= null) {
             student.setCourse(course);
             updateMoneyEarned(course);
             System.out.println(student.toString());
         } else {
             System.out.println("Couldn't assign the course");
         }

    }

    public void assignTeacher(String teacher_id, String course_id){
        Teacher teacher = findTeacherById(teacher_id);
        Course course = findCourseById(course_id);

        if (teacher != null && course!=null){
            course.setTeacher(teacher);
            System.out.println(course.toString());
        }else {
            System.out.println("Couldn't assign the course");
        }
    }

    private void updateMoneyEarned(Course course){
        double total = course.getMoney_earned() + course.getPrice();
        course.setMoney_earned(total);
    }

    private void handleShow(String[] command) {
        //System.out.println(Arrays.toString(command) + "del handle");
        switch (command[1].toUpperCase()){
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
                showProfit();
                break;
        }
    }

    private void showStudents() {
        System.out.println("llego a show students");
        StringBuilder studentsString = new StringBuilder();
        for (Student student: students){
            studentsString.append(student.toString()).append("\n");
        }
        System.out.println("Student usando el toString() es:");
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
        double totalEarned = courses.stream().mapToDouble(Course::getMoney_earned).sum();
        double totalSalaries = teachers.stream().mapToDouble(Teacher::getSalary).sum();

        System.out.println("===== FINANCIAL REPORT =====");
        System.out.println("Total income from courses: $" + totalEarned);
        System.out.println("Total expenses (teachers' salaries): $" + totalSalaries);
        System.out.println("------------------------------");
        System.out.printf("Net profit: $%.2f%n", (totalEarned - totalSalaries));
        System.out.println("==============================");
    }

    private void showCourses() {
        StringBuilder coursesString = new StringBuilder();
        for (Course course: courses){
            coursesString.append(course.toString()).append("\n");
        }
        System.out.println(coursesString);
    }


}
