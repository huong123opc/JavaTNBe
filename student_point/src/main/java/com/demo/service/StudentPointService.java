package com.demo.service;

import com.demo.dto.response.SubjectResponse;
import com.demo.model.SemesterOfStudent;

import java.util.List;

public interface StudentPointService {
    List<SemesterOfStudent> getSemesterOfStudents(String studentCode);

    List<SubjectResponse> getSubjectOfSemesters(String semesterOfStudentId);
}
