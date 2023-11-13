package com.spring.service;

import com.spring.controller.dto.NoticeCreateDto;
import com.spring.controller.dto.NoticeUpdateDto;
import com.spring.core.exception.CustomExceptionTest;
import com.spring.core.exception.ExceptionCode;
import com.spring.entity.Notice;
import com.spring.entity.User;
import com.spring.repository.NoticeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/applicationContext.xml"})
@Transactional
class NoticeServiceImplTest {

    @Autowired
    NoticeRepository noticeRepository;
    @Autowired
    NoticeService noticeService;

    @Test
    void 공지사항_생성_성공() {
        NoticeCreateDto dto = new NoticeCreateDto("제목","내용","Y");
        User user = new User("loginId","12345asd","이름","test@test.com","19950128","01012345678","남");

        int result = noticeService.create(dto,user);
        Assertions.assertThat(result).isEqualTo(1);
    }
    @Test
    void 공지사항_단건조회_성공() {
        noticeRepository.insert(new Notice("제목","내용","Y","작성자"));
        Notice notice = noticeRepository.getTestNotice("제목");

        Notice founedNotice = noticeService.getOneNotice(notice.getId());
        Assertions.assertThat(founedNotice.getId()).isNotNull();
    }
    @Test
    void 공지사항_단건조회_실패__공지사항_게시글ID에해당하는_게시글없음() {
        noticeRepository.insert(new Notice("제목","내용","Y","작성자"));

        CustomExceptionTest.assertThatCustomException(ExceptionCode.NOT_FOUND_NOTICE).isThrownBy(()-> noticeService.getOneNotice(1));

    }
    @Test
    void 공지사항_리스트조회_성공() {
        noticeRepository.insert(new Notice("제목1","내용1","Y","작성자1"));
        noticeRepository.insert(new Notice("제목2","내용2","Y","작성자2"));
        List<Notice> notices =  noticeService.getNotices("1",1,2);
        Assertions.assertThat(notices.size()).isEqualTo(1);


    }
    @Test
    void 공지사항_수정_성공() {
        noticeRepository.insert(new Notice("제목","내용","Y","작성자"));
        Notice notice = noticeRepository.getTestNotice("제목");

        NoticeUpdateDto dto = new NoticeUpdateDto("수정제목","수정내용","N");
        Notice updateNotice = noticeService.update(notice.getId(),dto);
        Assertions.assertThat(updateNotice.getTitle()).isEqualTo("수정제목");
        Assertions.assertThat(updateNotice.getContent()).isEqualTo("수정내용");
        Assertions.assertThat(updateNotice.getSecret()).isEqualTo("N");
    }
    @Test
    void 공지사항_삭제_성공() {
        noticeRepository.insert(new Notice("제목","내용","Y","작성자"));
        Notice notice = noticeRepository.getTestNotice("제목");

        int result = noticeService.delete(notice.getId());
        Assertions.assertThat(result).isEqualTo(1);
    }
}