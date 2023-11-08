package com.spring.controller;

import com.spring.controller.dto.UserUpdateDto;
import com.spring.core.response.ApiResult;
import com.spring.core.response.Result;
import com.spring.entity.User;
import com.spring.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<ApiResult<?>> update(@PathVariable int id, @RequestBody UserUpdateDto dto, HttpSession session){

        User user = userService.update(dto,id);

        session.setAttribute("user",user);

        return Result.ok();

    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<ApiResult<?>> delete(@PathVariable int id, HttpSession session){
        userService.delete(id);
        session.invalidate();
        return Result.ok();

    }

}
