package com.amir.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amir.backend.model.UserSession;

public interface  SessionRepository extends JpaRepository<UserSession , Integer> {

    Optional<UserSession> findByToken(String token);
    Optional<UserSession> findByUserId(Integer userId);
    
}
