package com.demo.service;

import com.demo.dto.SemesterDto;
import com.demo.dto.request.SemesterReq;

import java.util.List;

public interface SemesterService {
    List<SemesterDto> getSemesters();

    void createSemester(SemesterReq semesterReq);
}
