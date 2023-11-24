package com.demo.dto.request;

import lombok.Data;

@Data
public class SubjectReq {
    private String subjectCode;
    private String name;
    private int credit;
}
