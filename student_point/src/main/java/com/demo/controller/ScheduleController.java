package com.demo.controller;

import com.demo.dto.request.ScheduleOfStudentReq;
import com.demo.dto.request.ScheduleReq;
import com.demo.dto.response.utils.ResponseUtils;
import com.demo.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/admin/schedule")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<?> createSchedule(@RequestBody ScheduleReq scheduleReq) {
        scheduleService.createSchedule(scheduleReq);
        return ResponseUtils.created();
    }

    @GetMapping
    public ResponseEntity<?> getSchedules() {
        return ResponseUtils.ok(scheduleService.getSchedules());
    }

    @PostMapping("/register-schedule")
    public ResponseEntity<?> studentRegisterSchedule(@RequestBody ScheduleOfStudentReq scheduleOfStudentReq) {
        scheduleService.studentRegisterSchedule(scheduleOfStudentReq);
        return ResponseUtils.created();
    }

    @GetMapping("/schedule-of-student")
    public ResponseEntity<?> getScheduleOfStudent() {
        return ResponseUtils.ok(scheduleService.getScheduleOfStudent());
    }
}
