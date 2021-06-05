package com.example.springsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private Integer studentId;
    private String studentName;
}
