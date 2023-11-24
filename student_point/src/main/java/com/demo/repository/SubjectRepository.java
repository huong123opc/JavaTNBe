package com.demo.repository;

import com.demo.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, String> {
    Optional<Subject> findBySubjectCode(String subjectCode);
}
