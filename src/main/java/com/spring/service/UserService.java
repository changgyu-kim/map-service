package com.spring.service;

import com.spring.controller.dto.UserUpdateDto;
import com.spring.entity.User;

public interface UserService {

    User update(UserUpdateDto dto, int id);

    int delete(int id);
}
