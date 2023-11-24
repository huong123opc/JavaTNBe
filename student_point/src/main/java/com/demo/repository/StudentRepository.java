package com.demo.repository;

import com.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    boolean existsByStudentCode(String studentCode);
    Optional<Student> findByStudentCode(String studentCode);
}
