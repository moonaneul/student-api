package com.hongik.studentapi.controller;

import com.hongik.studentapi.entity.Student;
import com.hongik.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // 모든 학생 조회
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // 특정 이름으로 학생 조회
    @GetMapping("/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name) {
        Student student = studentRepository.findByName(name);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    // 학생 추가
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}