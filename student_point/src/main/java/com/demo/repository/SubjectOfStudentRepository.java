package com.demo.repository;

import com.demo.model.SemesterOfStudent;
import com.demo.model.SubjectOfStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectOfStudentRepository extends JpaRepository<SubjectOfStudent, String> {
    Optional<List<SubjectOfStudent>> findAllBySemesterOfStudent_Id(String id);

    Optional<List<SubjectOfStudent>> findAllByStudent_StudentCode(String studentCode);

    Optional<SubjectOfStudent> findByStudent_IdAndSubject_IdAndSemesterOfStudent(String studentId, String subjectId, SemesterOfStudent semesterOfStudent);
}
