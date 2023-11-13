package com.spring.service;

import com.spring.controller.dto.NoticeCreateDto;
import com.spring.controller.dto.NoticeUpdateDto;
import com.spring.entity.Notice;
import com.spring.entity.User;

import java.util.List;

public interface NoticeService {

    int create(NoticeCreateDto dto, User user);

    Notice getOneNotice(int id);
    List<Notice> getNotices(String keyword, int curPage, int pageSize);


    Notice update(int id, NoticeUpdateDto dto);

    int delete(int id);
}
