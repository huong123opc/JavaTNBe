package com.demo.service.impl;

import com.demo.dto.response.SubjectResponse;
import com.demo.exception.BaseErrorException;
import com.demo.model.SemesterOfStudent;
import com.demo.repository.SemesterOfStudentRepository;
import com.demo.repository.SubjectOfStudentRepository;
import com.demo.service.StudentPointService;
import com.demo.service.utils.MappingHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentPointServiceImpl implements StudentPointService {
    private final SemesterOfStudentRepository semesterOfStudentRepository;
    private final SubjectOfStudentRepository subjectOfStudentRepository;
    private final MappingHelper mappingHelper;

    @Override
    public List<SemesterOfStudent> getSemesterOfStudents(String studentCode) {
        return semesterOfStudentRepository
                .findByStudent_StudentCodeOrderBySemester_yearAscSemester_name(studentCode)
                .orElseThrow(() -> new BaseErrorException(
                        "Not found any semester of student: " + studentCode, null));
    }

    @Override
    public List<SubjectResponse> getSubjectOfSemesters(String semesterOfStudentId) {
        return subjectOfStudentRepository
                .findAllBySemesterOfStudent_Id(semesterOfStudentId)
                .orElseThrow(() -> new BaseErrorException("Not found any subject of student in this semester", null))
                .stream().map(e -> mappingHelper.map(e, SubjectResponse.class))
                .collect(Collectors.toList());
    }
}