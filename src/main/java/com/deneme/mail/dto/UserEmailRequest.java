package com.deneme.mail.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserEmailRequest {

    private String name;
    private String surname;

    public UserEmailRequest(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

