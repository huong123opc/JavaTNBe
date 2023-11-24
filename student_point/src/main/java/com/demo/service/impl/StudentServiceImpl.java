package com.demo.service.impl;

import com.demo.dto.StudentDto;
import com.demo.dto.request.StudentReq;
import com.demo.exception.BaseErrorException;
import com.demo.model.Account;
import com.demo.model.Student;
import com.demo.repository.AccountRepository;
import com.demo.repository.StudentRepository;
import com.demo.service.StudentService;
import com.demo.service.utils.MappingHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;
    private final AccountRepository accountRepository;
    private final MappingHelper mappingHelper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<StudentDto> getStudents() {
        return studentRepository.findAll().stream()
                .map(e -> mappingHelper.map(e, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createStudent(StudentReq studentReq) {
        logger.info("thông tin student",studentReq.getStudentCode(),studentReq.getClassCode());
        if (studentRepository.existsByStudentCode(studentReq.getStudentCode()))
            throw new BaseErrorException("Student code is existed", null);
        var student = mappingHelper.map(studentReq, Student.class);

        var s1 = studentRepository.save(student);
        var account = Account.builder()
                .student(s1)
                .username(student.getStudentCode())
                .password(passwordEncoder.encode(student.getStudentCode()))
                .build();
        accountRepository.save(account);
    }

    @Override
    public void deleteStudent(String id) {
       Student s = studentRepository.findById(id).orElseThrow(
               ()-> {
                   throw new BaseErrorException("Student code is existed", null);});

        studentRepository.delete(s);
    }
}
