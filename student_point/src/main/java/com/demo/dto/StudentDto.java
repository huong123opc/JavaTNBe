package com.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDto {
    private String id;
    private String studentCode;
    private String fullName;
    private Date dateOfBirth;
    private String address;
    private String classCode;
    private double cpa;
}
