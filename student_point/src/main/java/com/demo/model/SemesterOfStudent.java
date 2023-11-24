package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "semester_of_students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemesterOfStudent {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;
    private double gpa;
    private Float rootTuition;
    private Float exemptions;
    private Float receivable;
    private Float collected;
    private Float owed;

    public SemesterOfStudent(Student student, Semester semester) {
        this.student = student;
        this.semester = semester;
    }
}
