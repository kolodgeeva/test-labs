package com.example.testlabs.service.lab6.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryLab6 extends JpaRepository<UserLab6, String> {
    Optional<UserLab6> findByEmail(String email);
}

