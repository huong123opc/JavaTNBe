package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "subject_of_students")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectOfStudent {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "semester_student_id")
    private SemesterOfStudent semesterOfStudent;

    @Column(name = "attendance_point")
    private double attendancePoint;
    @Column(name = "test_point")
    private double testPoint;
    @Column(name = "practice_point")
    private double practicePoint;
    @Column(name = "exam_point")
    private double examPoint;
    @Column(name = "final_point")
    private double finalPoint;
    private double gpa;
    @Column(name = "letter_grade")
    private String letterGrade;
}