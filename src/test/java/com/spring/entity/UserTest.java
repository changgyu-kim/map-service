package com.spring.entity;

import com.spring.core.exception.CustomExceptionTest;
import com.spring.core.exception.ExceptionCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/applicationContext.xml"})
class UserTest {

    @Test
    void 유저_생성_성공() {
        User user = new User("loginId","12345asd","이름","test@test.com","19950128","01012345678","남","img.png");
        Assertions.assertThat(user.getId()).isNotNull();
        Assertions.assertThat(user.getLogin_id()).isEqualTo("loginId");
        Assertions.assertThat(user.getPassword()).isEqualTo("12345asd");
        Assertions.assertThat(user.getName()).isEqualTo("이름");
        Assertions.assertThat(user.getEmail()).isEqualTo("test@test.com");
        Assertions.assertThat(user.getBirth()).isEqualTo("19950128");
        Assertions.assertThat(user.getPhone()).isEqualTo("01012345678");
        Assertions.assertThat(user.getGender()).isEqualTo("남");
        Assertions.assertThat(user.getImg()).isEqualTo("img.png");
        Assertions.assertThat(user.getRole()).isEqualTo("USER_ROLE");
    }
    @ParameterizedTest
    @NullAndEmptySource
    void 유저_생성_실패__아이디_null_또는_빈값(String login_id) {
        Assertions.assertThatIllegalArgumentException().isThrownBy( () -> new User(login_id,"12345asd","이름","test@test.com","19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__아이디_4글자_미만() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_LOGIN_REQUEST).isThrownBy(() -> new User("aaa","12345asd","이름","test@test.com","19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__아이디_한글() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_LOGIN_REQUEST).isThrownBy(() -> new User("홍길동입니다","12345asd","이름","test@test.com","19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__아이디_특수문자() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_LOGIN_REQUEST).isThrownBy(() -> new User("!@#!@#","12345asd","이름","test@test.com","19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__아이디_12글자_초과() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_LOGIN_REQUEST).isThrownBy(() -> new User("aaaabbbbccccd","12345asd","이름","test@test.com","19950128","01012345678","남","img.png"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 유저_생성_실패__비밀번호_null_또는_빈값(String password) {
        Assertions.assertThatIllegalArgumentException().isThrownBy( () -> new User("loginId",password,"이름","test@test.com","19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__비밀번호_글자수8자_미만() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_LOGIN_REQUEST).isThrownBy(() -> new User("loginId","asd1231","이름","test@test.com","19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__비밀번호_글자수15자_초과() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_LOGIN_REQUEST).isThrownBy(() -> new User("loginId","asdf1234asdf1234","이름","test@test.com","19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__비밀번호_문자만입력() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_LOGIN_REQUEST).isThrownBy(() -> new User("loginId","asdfzxcv","이름","test@test.com","19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__비밀번호_숫자만입력() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_LOGIN_REQUEST).isThrownBy(() -> new User("loginId","12345678","이름","test@test.com","19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__비밀번호_한글입력() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_LOGIN_REQUEST).isThrownBy(() -> new User("loginId","비밀번호한글로작성","이름","test@test.com","19950128","01012345678","남","img.png"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 유저_생성_실패__이름_null_또는_빈값(String user) {
        Assertions.assertThatIllegalArgumentException().isThrownBy( () -> new User("loginId","12345asd",user,"test@test.com","19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__이름_두글자_미만() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_NAME_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","김","test@test.com","19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__이름_네글자_초과() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_NAME_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","김김김김김","test@test.com","19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__이름_영문자() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_NAME_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","kim","test@test.com","19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__이름_숫자() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_NAME_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","1239","test@test.com","19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__이름_특수문자() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_NAME_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","!@#!","test@test.com","19950128","01012345678","남","img.png"));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void 유저_생성_실패__이메일_null_또는_빈값(String email) {
        Assertions.assertThatIllegalArgumentException().isThrownBy( () -> new User("loginId","12345asd","이름",email,"19950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__이메일_형식위반() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_EMAIL_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","이름","testtest.com","19950128","01012345678","남","img.png"));
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_EMAIL_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","이름","test@testcom","19950128","01012345678","남","img.png"));

    }
    @ParameterizedTest
    @NullAndEmptySource
    void 유저_생성_실패__생년월일_null_또는_빈값(String birth) {
        Assertions.assertThatIllegalArgumentException().isThrownBy( () -> new User("loginId","12345asd","이름","test@test.com","01012345678",birth,"남","img.png"));
    }
    @Test
    void 유저_생성_실패__생년월일_8글자미만() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_BIRTH_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","이름","test@test.com","1995012","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__생년월일_8글자초과() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_BIRTH_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","이름","test@test.com","199501289","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__생년월일_년도범위벗어남() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_BIRTH_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","이름","test@test.com","18950128","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__생년월일_월범위벗어남() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_BIRTH_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","이름","test@test.com","19950028","01012345678","남","img.png"));
    }
    @Test
    void 유저_생성_실패__생년월일_일범위벗어남() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_BIRTH_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","이름","test@test.com","19951132","01012345678","남","img.png"));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void 유저_생성_실패__핸드폰번호_null_또는_빈값(String phone) {
        Assertions.assertThatIllegalArgumentException().isThrownBy( () -> new User("loginId","12345asd","이름","test@test.com",phone,"19950128","남","img.png"));
    }
    @Test
    void 유저_생성_실패__핸드폰번호_11글자미만() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_PHONE_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","이름","test@test.com","19951128","0101234567","남","img.png"));
    }
    @Test
    void 유저_생성_실패__핸드폰번호_11글자초과() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_PHONE_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","이름","test@test.com","19951128","010123456789","남","img.png"));
    }
    @Test
    void 유저_생성_실패__핸드폰번호_숫자이외_문자입력() {
        CustomExceptionTest.assertThatCustomException(ExceptionCode.FAIL_PHONE_REQUEST).isThrownBy(() -> new User("loginId","asdf1234","이름","test@test.com","19951128","asdfqwer","남","img.png"));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void 유저_생성_실패__성별_null_또는_빈값(String gender) {
        Assertions.assertThatIllegalArgumentException().isThrownBy( () -> new User("loginId","12345asd","이름","test@test.com","19950128","01012345678",gender,"img.png"));
    }
}