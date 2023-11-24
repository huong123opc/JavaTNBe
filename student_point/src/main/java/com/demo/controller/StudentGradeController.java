package com.demo.controller;

import com.demo.dto.request.StudentGradeReq;
import com.demo.service.StudentGradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StudentGradeController {
    private final StudentGradeService studentGradeService;

    @PostMapping("/student-grade")
    public ResponseEntity<?> enterGradeForStudent (@RequestBody @Valid StudentGradeReq studentGradeReq){
        return ResponseEntity.ok(studentGradeService.updateGradeForStudent(studentGradeReq));
    }

    @GetMapping("/semester")
    public ResponseEntity<?> getSemesterOfStudent (){
        return ResponseEntity.ok(studentGradeService.getSemesterOfStudent());
    }

    @GetMapping("/semester/{semesterStudentId}")
    public ResponseEntity<?> getSemesterOfStudentById (@PathVariable String semesterStudentId){
        return ResponseEntity.ok(studentGradeService.getSemesterOfStudentById(semesterStudentId));
    }

    @GetMapping("/subject-in-semester/{semesterOfStudentId}")
    public ResponseEntity<?> getSubjectInSemesterOfStudent (@PathVariable String semesterOfStudentId){
        return ResponseEntity.ok(studentGradeService.getSubjectInSemesterOfStudent(semesterOfStudentId));
    }

    @GetMapping("/subject-warning")
    public ResponseEntity<?> getSubjectWarning (){
        return ResponseEntity.ok(studentGradeService.getSubjectWarning());
    }
}
