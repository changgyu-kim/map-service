package com.spring.core.exception;

import lombok.Getter;

@Getter
public class CustomException extends  RuntimeException{

    private ExceptionCode exceptionCode;

    public CustomException(ExceptionCode exceptionCode){
        super(exceptionCode.name()); // 이걸 생성자로 받아야 예외이름을 받아올수 있다.
        this.exceptionCode = exceptionCode;
    }

    public static void validate(boolean expression, ExceptionCode exceptionCode){
        if(!expression){
            throw new CustomException(exceptionCode);
        }
    }



}
