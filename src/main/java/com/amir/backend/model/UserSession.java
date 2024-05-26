package com.amir.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sessionId;

    @Column(name = "token", unique = true)
    private String token;

    @Column(name = "user_id", unique = true)
    private Integer userId;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "session_start_time")
    private LocalDateTime sessionStartTime;

    @Column(name = "session_end_time")
    private LocalDateTime sessionEndTime;
}