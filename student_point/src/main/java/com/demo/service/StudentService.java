package com.demo.service;

import com.demo.dto.StudentDto;
import com.demo.dto.request.StudentReq;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();

    void createStudent(StudentReq studentReq);
    void deleteStudent(String id);
}
