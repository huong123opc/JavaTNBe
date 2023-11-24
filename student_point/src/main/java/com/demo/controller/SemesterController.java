package com.demo.controller;

import com.demo.dto.request.SemesterReq;
import com.demo.dto.response.utils.ResponseUtils;
import com.demo.service.SemesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/semesters")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SemesterController {
    private final SemesterService semesterService;

    @GetMapping
    public ResponseEntity<?> getSemesters() {
        return ResponseUtils.ok(semesterService.getSemesters());
    }

    @PostMapping
    public ResponseEntity<?> createSemester(@RequestBody SemesterReq semesterReq) {
        semesterService.createSemester(semesterReq);
        return ResponseUtils.created();
    }
}
