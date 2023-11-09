package com.spring.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/applicationContext.xml"})
class NoticeTest {
    @Test
    void 공지사항_생성_성공() {
        Notice notice = new Notice("제목","내용","Y","작성자");
        Assertions.assertThat(notice.getTitle()).isEqualTo("제목");
        Assertions.assertThat(notice.getContent()).isEqualTo("내용");
        Assertions.assertThat(notice.getSecret()).isEqualTo("Y");
        Assertions.assertThat(notice.getWriter()).isEqualTo("작성자");
        Assertions.assertThat(notice.getCreatedAt()).isNotNull();
    }
    @ParameterizedTest
    @NullAndEmptySource
    void 공지사항_생성_실패__제목_NULL_또는_공백(String title) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(()-> new Notice(title,"내용","Y","작성자"));
    }
    @Test
    void 공지사항_생성_실패__제목_30글자초과() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(()-> new Notice("제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제","내용","Y","작성자"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 공지사항_생성_실패__내용_NULL_또는_공백(String content) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(()-> new Notice("제목",content,"Y","작성자"));
    }
    @Test
    void 공지사항_생성_실패__내용_1000글자초과() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(()-> new Notice("제목","내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내","Y","작성자"));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void 공지사항_생성_실패__시크릿_NULL_또는_공백(String secret) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(()-> new Notice("제목","내용",secret,"작성자"));
    }
    @Test
    void 공지사항_생성_실패__시크릿_Y_또는_N_이외의값() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(()-> new Notice("제목","내용","asd","작성자"));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void 공지사항_생성_실패__작성자_NULL_또는_공백(String writer) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(()-> new Notice("제목","내용","내용",writer));
    }
}