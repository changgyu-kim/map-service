package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    @GetMapping("/")
    public String home(){
        return "root.index";

    }
    @GetMapping("/sign-in")
    public String signIn(){
        return "sign-in";
    }
    @GetMapping("/sign-up")
    public String signUp(){
        return "sign-up";
    }
    @GetMapping("/mypage")
    public String mypage(){ return "root.mypage";}
    @GetMapping("/notice")
    public String notice(){
        return "root.notice";
    }
}
