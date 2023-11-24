package com.demo.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedules")
@Data
public class Schedule {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    private String place;
    private String note;
    private Date date;
    private Date startTime;
    private Date finishTime;
    private String lecturer;
    private String emailLecture;
}
