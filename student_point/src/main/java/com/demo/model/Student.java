package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "student_code", unique = true)
    private String studentCode;
    @Column(name = "full_name")
    private String fullName;
    private Date dateOfBirth;
    private String address;
    @Column(name = "class_code")
    private String classCode;
    private double cpa;

    @OneToOne(mappedBy = "student",cascade = CascadeType.REMOVE)
    private Account account;
}