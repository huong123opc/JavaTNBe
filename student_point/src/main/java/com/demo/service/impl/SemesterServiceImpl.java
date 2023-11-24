package com.demo.service.impl;

import com.demo.dto.SemesterDto;
import com.demo.dto.request.SemesterReq;
import com.demo.exception.BaseErrorException;
import com.demo.model.Semester;
import com.demo.repository.SemesterRepository;
import com.demo.service.SemesterService;
import com.demo.service.utils.MappingHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SemesterServiceImpl implements SemesterService {
    private final SemesterRepository semesterRepository;
    private final MappingHelper mappingHelper;

    @Override
    public List<SemesterDto> getSemesters() {
        return semesterRepository.findAll()
                .stream().map(e -> mappingHelper.map(e, SemesterDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createSemester(SemesterReq semesterReq) {
        if (semesterRepository.existsByNameAndYear(semesterReq.getName(), semesterReq.getYear()))
            throw new BaseErrorException("Semester is existed", null);
        semesterRepository.save(mappingHelper.map(semesterReq, Semester.class));
    }
}
