package com.hongik.studentapi.model;

public class Student {
    private String name;
    private String email;
    private String degree;
    private int graduation;

    // 생성자
    public Student(String name, String email, String degree, int graduation) {
        this.name = name;
        this.email = email;
        this.degree = degree;
        this.graduation = graduation;
    }

    // Getter와 Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getGraduation() {
        return graduation;
    }

    public void setGraduation(int graduation) {
        this.graduation = graduation;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", degree='" + degree + '\'' +
                ", graduation=" + graduation +
                '}';
    }
}