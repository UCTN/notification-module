package com.deneme.mail.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {

    private String name;
    private String surname;
    private String role;
    private LocalDateTime createdAt;

    public UserResponse(String name, String surname, String role, LocalDateTime createdAt) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.createdAt = createdAt;
    }
}

