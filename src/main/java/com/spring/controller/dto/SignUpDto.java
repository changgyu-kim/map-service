package com.spring.controller.dto;

import lombok.Data;

@Data
public class SignUpDto {
    private String loginId;
    private String password;
    private String passwordC;
    private String name;
    private String email;
    private String birth;
    private String phone;
    private String gender;

    public SignUpDto(){}
    public SignUpDto(String loginId, String password, String passwordC, String name, String email, String birth, String phone, String gender) {
        this.loginId = loginId;
        this.password = password;
        this.passwordC = passwordC;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.phone = phone;
        this.gender = gender;
    }

}
