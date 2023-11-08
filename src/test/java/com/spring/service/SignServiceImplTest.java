package com.spring.service;

import com.spring.controller.dto.SignInDto;
import com.spring.controller.dto.SignUpDto;
import com.spring.core.exception.CustomExceptionTest;
import com.spring.core.exception.ExceptionCode;
import com.spring.entity.User;
import com.spring.repository.SignRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/applicationContext.xml"})
@Transactional
class SignServiceImplTest {

    @Autowired
    SignService signService;

    @Autowired
    SignRepository signRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void 회원가입_성공() {
        SignUpDto dto = new SignUpDto("loginId","12345asd","12345asd","이름","test@test.com","19950128","01012345678","남");
        int result = signService.signUp(dto);
        Assertions.assertThat(result).isEqualTo(1);
    }
    @Test
    void 회원가입_실패__비밀번호_입력된두개의값이_다름() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.NOT_EQUALS_PASSWORD).isThrownBy(() ->signService.signUp(new SignUpDto("loginId","12345qwe","12345asd","이름","test@test.com","19950128","01012345678","남")));
    }

    @Test
    void 로그인_성공() {
        signRepository.insert(new User("loginId", passwordEncoder.encode("12345asd"), "이름", "test@test.com", "19950128", "01012345678", "남"));
        SignInDto dto = new SignInDto("loginId","12345asd");
         User user = signService.signIn(dto);
         Assertions.assertThat(user.getId()).isNotNull();
    }
    @Test
    void 로그인_실패__유저정보_NULL() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.NOT_FOUND_USER).isThrownBy(()->signService.signIn(new SignInDto("loginId","12345asd")));
    }
    @Test
    void 로그인_실패__패스워드_불일치() {
        signRepository.insert(new User("loginId", passwordEncoder.encode("12345asd"), "이름", "test@test.com", "19950128", "01012345678", "남"));
        CustomExceptionTest.assertThatCustomException(ExceptionCode.NOT_EQUALS_PASSWORD).isThrownBy(()->signService.signIn(new SignInDto("loginId","12345qwe")));
    }
}