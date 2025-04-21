package com.example;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class Student {
    private static final Set<String> usedIds = new HashSet<>();

    private final String studentId;
    private String name;
    private String address;
    private String email;
    private Course course;

    public Student(String name,String address,String email) {
        this.studentId = generateUniqueStudentId();
        this.name = name;
        this.address = address;
        this.email = email;
        this.course = null;
    }

    public Student(){
        this.studentId = generateUniqueStudentId();
    }

    private String generateUniqueStudentId() {
        String id;
        Random random = new Random();
        do {
            int number = random.nextInt(900) + 100;
            id = "S" + number;
        } while (usedIds.contains(id));

        usedIds.add(id);
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new IllegalArgumentException("El nombre no puede contener números ni caracteres especiales.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
      return "\n📘 Student Info\n" +
                "------------------------\n" +
                "🆔 ID       : " + studentId + "\n" +
                "👤 Name     : " + name + "\n" +
                "🏠 Address  : " + address + "\n" +
                "📧 Email    : " + email + "\n" +
                "📚 Course   : " + (course != null ? getCourse().getName() : "Not enrolled") + "\n";
    }
}

