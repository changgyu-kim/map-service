package com.spring.entity;

import com.spring.utils.time.Time;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

import static com.spring.utils.conditions.PreConditions.isNotBlank;
import static com.spring.utils.conditions.PreConditions.require;

@Data
public class Notice { // Entity 테스트부터 진행해야함
    private int id;
    private String title;
    private String content;
    private String secret;
    private String writer;
    private Date createdAt = Time.insertTime(LocalDate.now());

    public Notice(){}

    public Notice(String title, String content, String secret, String writer) {
        require(isNotBlank(title));
        require(isNotBlank(content));
        require(isNotBlank(secret));
        require(isNotBlank(writer));
        require(title.length() <= 30);
        require(content.length() <= 1000);
        require(secret.equals("Y") || secret.equals("N"));
        this.title = title;
        this.content = content;
        this.secret = secret;
        this.writer = writer;
    }
    public void update(String title, String content, String secret){
        require(isNotBlank(title));
        require(isNotBlank(content));
        require(isNotBlank(secret));
        require(title.length() <= 30);
        require(content.length() <= 1000);
        require(secret.equals("Y") || secret.equals("N"));
        this.title = title;
        this.content = content;
        this.secret = secret;
    }
}
