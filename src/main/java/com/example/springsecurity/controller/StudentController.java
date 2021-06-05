package com.example.springsecurity.controller;

import com.example.springsecurity.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> LIST_STUDENT = Arrays.asList(
            new Student(1, "Tran Quoc Viet"),
            new Student(2, "Viet Tran"),
            new Student(3, "Viet Tran Quoc")

    );

    @GetMapping(path = "{studentId}")
    public Student getListStudent(@PathVariable("studentId") Integer studentId) {
        Student student = LIST_STUDENT.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student " + studentId + "is not exist !"));
        return student;
    }
}
