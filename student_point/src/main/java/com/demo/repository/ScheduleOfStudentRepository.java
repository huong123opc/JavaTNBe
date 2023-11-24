package com.demo.repository;

import com.demo.model.ScheduleOfStudent;
import com.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleOfStudentRepository extends JpaRepository<ScheduleOfStudent, String> {
    List<ScheduleOfStudent> findAllByStudent(Student student);
}
