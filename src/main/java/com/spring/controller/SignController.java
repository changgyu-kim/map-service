package com.spring.controller;

import com.spring.controller.dto.SignInDto;
import com.spring.controller.dto.SignUpDto;
import com.spring.entity.User;
import com.spring.service.SignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SignController {

    private SignService signService;

    public SignController(SignService signService) {
        this.signService = signService;
    }

    @PostMapping("sign-up")
    public String signUp(SignUpDto dto){
        signService.signUp(dto);
        return "redirect:/sign-up";
    }

    @PostMapping("sign-in")
    public String signIn(SignInDto dto, HttpSession session){
        User user = signService.signIn(dto);
        session.setAttribute("user",user);

        return "redirect:/";
    }

}
