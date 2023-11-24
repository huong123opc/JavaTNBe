package com.demo.dto.response;

import com.demo.model.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectResponse {
    private String id;
    private Subject subject;
    private double attendancePoint;
    private double testPoint;
    private double practicePoint;
    private double examPoint;
    private double finalPoint;
    private double gpa;
    private String letterGrade;
}
