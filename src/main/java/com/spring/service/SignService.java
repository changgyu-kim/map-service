package com.spring.service;

import com.spring.controller.dto.SignInDto;
import com.spring.controller.dto.SignUpDto;
import com.spring.entity.User;

public interface SignService {

    int signUp(SignUpDto dto);
    User signIn(SignInDto dto);

}
