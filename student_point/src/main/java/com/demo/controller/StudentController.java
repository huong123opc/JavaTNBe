package com.demo.controller;

import com.demo.dto.BaseResponse;
import com.demo.dto.request.StudentReq;
import com.demo.dto.response.utils.ResponseUtils;
import com.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/students")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getStudents (){
        return ResponseUtils.ok(studentService.getStudents());
    }

    @PostMapping
    public ResponseEntity<?> createStudent (@RequestBody StudentReq studentReq){
        studentService.createStudent(studentReq);
        return ResponseUtils.created();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudents (@PathVariable("id") String id ){
    studentService.deleteStudent(id);
        return ResponseEntity.ok(BaseResponse.of("Success","oke"));
    }
}
