package com.spring.core.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {

    SUCCESS("S000","success"),
    ERROR("E000","치명적 오류가 발생 했습니다."),
    FAIL_LOGIN_REQUEST("E001","아이디 또는 패스워드를 확인해주세요"),
    FAIL_NAME_REQUEST("E002","이름을 형식에 맞게 작성해주세요"),
    FAIL_EMAIL_REQUEST("E003","이메일주소를 확인해주세요"),
    FAIL_BIRTH_REQUEST("E004","생년월일을 확인해주세요"),
    FAIL_PHONE_REQUEST("E005","휴대전화번호를 확인해주세요"),
    NOT_EQUALS_PASSWORD("E006","패스워드가 일치하지 않습니다"),
    NOT_FOUND_USER("E007", "유저정보가 없습니다.")
    

    ;

    private String code;
    private String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
