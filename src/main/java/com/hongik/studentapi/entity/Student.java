package com.hongik.studentapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students") // 데이터베이스의 students 테이블과 매핑
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String degree;

    @Column(nullable = false)
    private Integer graduation;


    public Student() {}


    public Student(String name, String email, String degree, Integer graduation) {
        this.name = name;
        this.email = email;
        this.degree = degree;
        this.graduation = graduation;
    }


    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

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

    public Integer getGraduation() {
        return graduation;
    }

    public void setGraduation(Integer graduation) {
        this.graduation = graduation;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", degree='" + degree + '\'' +
                ", graduation=" + graduation +
                '}';
    }
}