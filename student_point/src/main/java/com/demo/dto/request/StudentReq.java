package com.demo.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class StudentReq {
    private String studentCode;
    private String fullName;
    private Date dateOfBirth;
    private String address;
    private String classCode;
}
