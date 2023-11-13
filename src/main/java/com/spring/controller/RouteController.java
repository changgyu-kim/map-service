package com.spring.controller;

import com.spring.entity.Notice;
import com.spring.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RouteController {

    private final NoticeService noticeService;

    public RouteController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

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
    @GetMapping("/notice-write")
    public String noticeWrite(){
        return "root.noticeWrite";
    }
    @GetMapping("/notice-detail/{id}")
    public String getOneNotice(@PathVariable int id, Model m){
        m.addAttribute("id",id);

        return "root.noticeDetail";
    }
    @GetMapping("/notice-update/{id}")
    public String noticeUpdate(@PathVariable int id, Model m){
        Notice notice = noticeService.getOneNotice(id);
        m.addAttribute("notice",notice);
        return "root.noticeUpdate";
    }

}
