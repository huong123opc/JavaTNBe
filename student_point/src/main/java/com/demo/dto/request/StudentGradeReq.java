package com.demo.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentGradeReq {
    @NotBlank
    private String studentId;
    @NotBlank
    private String subjectId;
    @NotBlank
    private String semesterId;
    private double attendancePoint;
    private double testPoint;
    private double practicePoint;
    private double examPoint;
}
