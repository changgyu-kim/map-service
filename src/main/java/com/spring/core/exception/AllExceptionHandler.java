package com.spring.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AllExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Throwable.class})
    public String exception(Throwable throwable){
        System.out.println("throwable = " + throwable.getMessage());

        return "error";
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class})
    public String illegalArgumentException(Exception e){
        System.out.println("e = " + e.getMessage());

        return "error";
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({CustomException.class})
    public String customException(Exception e){
        System.out.println(e.getMessage());
        return "error";
    }
}
