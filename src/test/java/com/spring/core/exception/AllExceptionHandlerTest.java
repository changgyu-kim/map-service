package com.spring.core.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/applicationContext.xml"})
class AllExceptionHandlerTest {

    @Test
    void 예외핸들러테스트() {
        throw new RuntimeException("error");
    }
    @Test
    void 커스텀예외핸들러테스트() {
        throw new CustomException(ExceptionCode.NOT_EQUALS_PASSWORD);
    }
}