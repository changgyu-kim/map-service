package com.spring.core.exception;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.assertj.core.api.ThrowableTypeAssert;

public class CustomExceptionTest {
    private final ExceptionCode exceptionCode;
    private final ThrowableTypeAssert<CustomException> throwableTypeAssert; // ThrowableTypeAssert 객체는 assertj-core 라이브러리이고 테스트코드에서만 사용된다. 어플리케이션에서 사용하려면 주입받아야함


    public CustomExceptionTest(ExceptionCode exceptionCode, ThrowableTypeAssert<CustomException> throwableTypeAssert) {
        this.exceptionCode = exceptionCode;
        this.throwableTypeAssert = throwableTypeAssert;
    }

    public static CustomExceptionTest assertThatCustomException(ExceptionCode exceptionCode){
        return new CustomExceptionTest(exceptionCode, Assertions.assertThatExceptionOfType(CustomException.class));
    }

    public void isThrownBy(ThrowableAssert.ThrowingCallable throwingCallable){
        this.throwableTypeAssert.isThrownBy(throwingCallable).withMessage(exceptionCode.name()); // withMessage(exceptionCode.name()) 할경우 내가 발생한 에러이름이 들어감
    }


}
