package com.demo.service;

import com.demo.dto.SubjectDto;
import com.demo.dto.request.SubjectReq;

import java.util.List;

public interface SubjectService {
    List<SubjectDto> getSubjects();

    void createSubject(SubjectReq subjectReq);
}
