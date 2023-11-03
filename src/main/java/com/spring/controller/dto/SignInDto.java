package com.spring.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class SignInDto {
    private String login_id;
    private String password;

    public SignInDto(String login_id, String password) {
        this.login_id = login_id;
        this.password = password;
    }
}
