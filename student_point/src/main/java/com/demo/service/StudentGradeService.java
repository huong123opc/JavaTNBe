package com.demo.service;

import com.demo.dto.BaseResponse;
import com.demo.dto.request.StudentGradeReq;

public interface StudentGradeService {
    BaseResponse updateGradeForStudent(StudentGradeReq studentGradeReq);

    BaseResponse getSemesterOfStudent();

    BaseResponse getSubjectInSemesterOfStudent(String semesterOfStudentId);

    BaseResponse getSemesterOfStudentById(String semesterStudentId);

    BaseResponse getSubjectWarning();
}
