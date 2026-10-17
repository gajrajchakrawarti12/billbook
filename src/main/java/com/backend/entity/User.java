package com.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(indexes = @Index(name = "email", unique = true, columnList = "email"))
@RequiredArgsConstructor
@Getter
@Setter 
public class User {
    @Id
    private String id;
    private String email;
    private String passwordHash;
    private String givenName;
    private boolean authProvider;
    private boolean isActive;
    private LocalDateTime lastLoginAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
