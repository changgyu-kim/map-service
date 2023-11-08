package com.spring.controller;

import com.spring.controller.dto.SignInDto;
import com.spring.controller.dto.SignUpDto;
import com.spring.core.response.ApiResult;
import com.spring.core.response.Result;
import com.spring.entity.User;
import com.spring.service.SignService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class SignController {

    private SignService signService;

    public SignController(SignService signService) {
        this.signService = signService;
    }

    @ResponseBody
    @PostMapping("/sign-up")
    public ResponseEntity<ApiResult<?>> signUp(@RequestBody SignUpDto dto){
        signService.signUp(dto);
        return Result.created();
    }

    @ResponseBody
    @PostMapping("/sign-in")
    public ResponseEntity<ApiResult<User>> signIn(@RequestBody SignInDto dto, HttpSession session){
        User user = signService.signIn(dto);
        session.setAttribute("user",user);

        return Result.ok(user);
    }
    @GetMapping("/sign-out")
    public String signIn(HttpSession session){
        session.invalidate();

        return "redirect:/";
    }

}
