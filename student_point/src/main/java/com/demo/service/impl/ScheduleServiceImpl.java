package com.demo.service.impl;

import com.demo.dto.ScheduleDto;
import com.demo.dto.SubjectDto;
import com.demo.dto.request.ScheduleOfStudentReq;
import com.demo.dto.request.ScheduleReq;
import com.demo.exception.BaseErrorException;
import com.demo.model.Account;
import com.demo.model.Schedule;
import com.demo.model.ScheduleOfStudent;
import com.demo.model.Subject;
import com.demo.repository.*;
import com.demo.service.ScheduleService;
import com.demo.service.utils.MappingHelper;
import com.demo.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final AccountRepository accountRepository;
    private final ScheduleRepository scheduleRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    private final ScheduleOfStudentRepository scheduleOfStudentRepository;
    private final MappingHelper mappingHelper;
    private final JwtUtils jwtUtils;

    @Override
    public void createSchedule(ScheduleReq scheduleReq) {
        Subject subject = subjectRepository.findById(scheduleReq.getSubjectId())
                .orElseThrow(() -> new BaseErrorException(
                        "Subject not found with id : " + scheduleReq.getSubjectId(), null
                ));
        var schedule = mappingHelper.map(scheduleReq, Schedule.class);
        schedule.setSubject(subject);
        scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> getScheduleOfStudent() {
        var account = getCurrentAccount();
        return scheduleOfStudentRepository.findAllByStudent(account.getStudent())
                .stream().map(ScheduleOfStudent::getSchedule)
                .collect(Collectors.toList());
    }

    @Override
    public void studentRegisterSchedule(ScheduleOfStudentReq scheduleOfStudentReq) {
        var schedule = scheduleRepository.findById(scheduleOfStudentReq.getScheduleId())
                .orElseThrow(() -> new BaseErrorException(
                        "Schedule not found with id: " + scheduleOfStudentReq.getScheduleId(), null
                ));
        var student = studentRepository.findById(scheduleOfStudentReq.getStudentId())
                .orElseThrow(() -> new BaseErrorException(
                        "Student not found with id: " + scheduleOfStudentReq.getStudentId(), null
                ));
        var res = mappingHelper.map(scheduleOfStudentReq, ScheduleOfStudent.class);
        res.setSchedule(schedule);
        res.setStudent(student);
        scheduleOfStudentRepository.save(res);
    }

    @Override
    public List<ScheduleDto> getSchedules() {
        return scheduleRepository.findAll().stream()
                .map(e -> {
                    var res = mappingHelper.map(e, ScheduleDto.class);
                    res.setSubjectDto(mappingHelper.map(e.getSubject(), SubjectDto.class));
                    return res;
                }).collect(Collectors.toList());
    }

    private Account getCurrentAccount() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String headerAuth = request.getHeader("Authorization");
        String jwtToken = StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ") ?
                headerAuth.substring(7) : null;

        return accountRepository.findByUsername(jwtUtils.getUsernameFromToken(jwtToken))
                .orElseThrow(() -> new BaseErrorException("Your session is expiated", null));

//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getDetails();
//        return accountRepository.findByUsername(user.getUsername()).get();
    }
}
