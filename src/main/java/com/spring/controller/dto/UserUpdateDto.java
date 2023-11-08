package com.spring.controller.dto;

import lombok.Data;

@Data
public class UserUpdateDto {
    private String password;
    private String name;
    private String email;
    private String phone;

    public UserUpdateDto(){};

    public UserUpdateDto(String password, String name, String email, String phone){
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
