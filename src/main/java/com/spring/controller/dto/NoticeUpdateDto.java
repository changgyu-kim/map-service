package com.spring.controller.dto;

import lombok.Getter;

@Getter
public class NoticeUpdateDto {
    private String title;
    private String content;
    private String secret;

    public NoticeUpdateDto(){}
    public NoticeUpdateDto(String title, String content, String secret) {
        this.title = title;
        this.content = content;
        this.secret = secret;
    }
}
