package com.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ScheduleDto {
    private String id;
    private SubjectDto subjectDto;
    private String place;
    private String note;
    private Date date;
    private Date startTime;
    private Date finishTime;
    private String lecturer;
    private String emailLecture;
}
