package com.spring.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class SignUpDto {
    private String login_id;
    private String password;
    private String passwordC;
    private String name;
    private String email;
    private String birth;
    private String phone;
    private String gender;

    public SignUpDto(String login_id, String password, String passwordC, String name, String email, String birth, String phone, String gender) {
        this.login_id = login_id;
        this.password = password;
        this.passwordC = passwordC;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.phone = phone;
        this.gender = gender;
    }
}
