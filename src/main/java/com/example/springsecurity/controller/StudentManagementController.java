package com.example.springsecurity.controller;

import com.example.springsecurity.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> LIST_STUDENT = Arrays.asList(
            new Student(1, "Tran Quoc Viet"),
            new Student(2, "Viet Tran"),
            new Student(3, "Viet Tran Quoc")

    );

    @GetMapping
    public List<Student> getAllStudents() {
        return LIST_STUDENT;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        System.out.println(String.format("%s %s", studentId, student));
    }
}
