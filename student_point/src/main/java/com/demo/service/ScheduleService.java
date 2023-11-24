package com.demo.service;

import com.demo.dto.ScheduleDto;
import com.demo.dto.request.ScheduleOfStudentReq;
import com.demo.dto.request.ScheduleReq;
import com.demo.model.Schedule;

import java.util.List;

public interface ScheduleService {
    void createSchedule(ScheduleReq scheduleReq);

    List<Schedule> getScheduleOfStudent();

    void studentRegisterSchedule(ScheduleOfStudentReq scheduleOfStudentReq);

    List<ScheduleDto> getSchedules();
}
