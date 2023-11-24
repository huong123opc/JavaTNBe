package com.demo.controller;

import com.demo.dto.request.StudentReq;
import com.demo.dto.request.SubjectReq;
import com.demo.dto.response.utils.ResponseUtils;
import com.demo.service.StudentService;
import com.demo.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/subjects")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping
    public ResponseEntity<?> getSubjects (){
        return ResponseUtils.ok(subjectService.getSubjects());
    }

    @PostMapping
    public ResponseEntity<?> createSubject (@RequestBody SubjectReq subjectReq){
        subjectService.createSubject(subjectReq);
        return ResponseUtils.created();
    }
}
