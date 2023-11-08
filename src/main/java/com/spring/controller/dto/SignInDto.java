package com.spring.controller.dto;

import lombok.Getter;

@Getter
public class SignInDto {
    private String loginId;
    private String password;

    public SignInDto(){}

    public SignInDto(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
