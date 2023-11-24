package com.demo.repository;

import com.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByUsername(String username);
    Optional<Account> findByEmail(String email);
    Optional<Account> findByStudent(String student);
    boolean existsByEmailOrUsername(String email, String username);
}
