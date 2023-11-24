package com.demo.controller;

import com.demo.dto.request.StudentGradeReq;
import com.demo.dto.response.utils.ResponseUtils;
import com.demo.service.StudentGradeService;
import com.demo.service.StudentPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin/student-point")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StudentPointController {
    private final StudentGradeService studentGradeService;
    private final StudentPointService studentPointService;

    @PostMapping
    public ResponseEntity<?> enterGradeForStudent(@RequestBody @Valid StudentGradeReq studentGradeReq) {
        return ResponseUtils.ok(studentGradeService.updateGradeForStudent(studentGradeReq));
    }

    @GetMapping("/semester/student-code/{studentCode}")
    public ResponseEntity<?> getSemesterOfStudents(@PathVariable String studentCode) {
        return ResponseUtils.ok(studentPointService.getSemesterOfStudents(studentCode));
    }

    @GetMapping("/subject-of-semester/{semesterOfStudentId}")
    public ResponseEntity<?> getSubjectOfSemesters(@PathVariable String semesterOfStudentId) {
        return ResponseUtils.ok(studentPointService.getSubjectOfSemesters(semesterOfStudentId));
    }

    @GetMapping("/semester/{semesterStudentId}")
    public ResponseEntity<?> getSemesterOfStudentById(@PathVariable String semesterStudentId) {
        return ResponseEntity.ok(studentGradeService.getSemesterOfStudentById(semesterStudentId));
    }

    @GetMapping("/subject-in-semester/{semesterOfStudentId}")
    public ResponseEntity<?> getSubjectInSemesterOfStudent(@PathVariable String semesterOfStudentId) {
        return ResponseEntity.ok(studentGradeService.getSubjectInSemesterOfStudent(semesterOfStudentId));
    }
}
