package com.spring.controller.dto;

import lombok.Getter;

@Getter
public class NoticeCreateDto {
    private String title;
    private String content;
    private String secret;

    public NoticeCreateDto(){}

    public NoticeCreateDto(String title, String content, String secret) {
        this.title = title;
        this.content = content;
        this.secret = secret;
    }
}
