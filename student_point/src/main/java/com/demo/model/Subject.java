package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "subject_code", unique = true)
    private String subjectCode;
    private String name;
    private int credit;

    public Subject(String subjectCode, String name, int credit) {
        this.subjectCode = subjectCode;
        this.name = name;
        this.credit = credit;
    }
}
