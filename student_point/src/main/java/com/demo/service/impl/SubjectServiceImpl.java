package com.demo.service.impl;

import com.demo.dto.SubjectDto;
import com.demo.dto.request.SubjectReq;
import com.demo.exception.BaseErrorException;
import com.demo.model.Subject;
import com.demo.repository.SubjectRepository;
import com.demo.service.SubjectService;
import com.demo.service.utils.MappingHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final MappingHelper mappingHelper;

    @Override
    public List<SubjectDto> getSubjects() {
        return subjectRepository.findAll().stream()
                .map(e -> mappingHelper.map(e, SubjectDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createSubject(SubjectReq subjectReq) {
        if (subjectRepository.findBySubjectCode(subjectReq.getSubjectCode()).isPresent())
            throw new BaseErrorException("Subject code is existed", null);
        subjectRepository.save(mappingHelper.map(subjectReq, Subject.class));
    }
}
