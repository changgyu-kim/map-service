package com.spring.controller;

import com.spring.controller.dto.NoticeCreateDto;
import com.spring.controller.dto.NoticeUpdateDto;
import com.spring.core.response.ApiResult;
import com.spring.core.response.Result;
import com.spring.entity.Notice;
import com.spring.entity.User;
import com.spring.service.NoticeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @ResponseBody
    @PostMapping("/notice-create")
    public ResponseEntity<ApiResult<?>> create(@RequestBody NoticeCreateDto dto, HttpSession session){
        User user = (User) session.getAttribute("user");
        noticeService.create(dto, user);
        return Result.created();
    }
    @ResponseBody
    @GetMapping("/notices")
    public ResponseEntity<ApiResult<List<Notice>>> getNotices(@RequestParam(required = false) String keyword ,
                                   @RequestParam(defaultValue = "1") int curPage,
                                   @RequestParam(defaultValue = "5") int pageSize){
           List<Notice> notices = noticeService.getNotices(keyword, curPage, pageSize);

           return Result.ok(notices);
    }
    @GetMapping("/notice/{id}")
    public String getOneNotice(@PathVariable int id, Model m){
        Notice notice = noticeService.getOneNotice(id);
        m.addAttribute("notice",notice);

        return "root.noticeDetail";
    }
    @ResponseBody
    @PatchMapping("/notice/{id}")
    public ResponseEntity<ApiResult<Notice>> update(@PathVariable int id, @RequestBody NoticeUpdateDto dto, Model m){
        Notice notice = noticeService.update(id, dto);
        m.addAttribute("notice",notice);
        return Result.ok(notice);
    }

    @ResponseBody
    @DeleteMapping("/notice/{id}")
    public ResponseEntity<ApiResult<?>> delete(@PathVariable int id){
        noticeService.delete(id);

        return Result.ok();
    }
}
