package com.demo.repository;

import com.demo.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SemesterRepository extends JpaRepository<Semester, String> {
    Optional<Semester> findByName(String name);

    Boolean existsByNameAndYear(String name, String year);
}