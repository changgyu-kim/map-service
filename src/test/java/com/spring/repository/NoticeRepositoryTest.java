package com.spring.repository;

import com.spring.entity.Notice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/applicationContext.xml"})
@Transactional
class NoticeRepositoryTest {

    @Autowired
    NoticeRepository noticeRepository;

    @Test
    void 공지사항_생성_성공() {
        int result = noticeRepository.insert(new Notice("제목","내용","Y","작성자"));
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void 공지사항_단건조회_성공() {
        int result = noticeRepository.insert(new Notice("제목","내용","Y","작성자"));
        Notice notice = noticeRepository.getTestNotice("제목");

        Notice findedNotice = noticeRepository.findById(notice.getId());
        Assertions.assertThat(findedNotice.getId()).isNotNull();
    }
    @Test
    void 공지사항_리스트조회_성공__keyword_NULL() {
        noticeRepository.insert(new Notice("제목","내용","Y","작성자"));
        noticeRepository.insert(new Notice("제목1","내용1","Y","작성자1"));
        Map map = new HashMap();
        map.put("offset",0);
        map.put("pageSize",2);
        List<Notice> findedNotice = noticeRepository.findAll(map);
        Assertions.assertThat(findedNotice.size()).isEqualTo(2);
    }
    @Test
    void 공지사항_리스트조회_성공__keyword_있음() {
        noticeRepository.insert(new Notice("제목","내용","Y","작성자"));
        noticeRepository.insert(new Notice("제목1","내용1","Y","작성자1"));
        String keyword = "1";
        Map map = new HashMap();
        map.put("offset",0);
        map.put("pageSize",2);
        map.put("keyword",keyword);
        List<Notice> findedNotice = noticeRepository.findAll(map);
        Assertions.assertThat(findedNotice.size()).isEqualTo(1);
    }
    @Test
    void 공지사항_업데이트_성공() {
        noticeRepository.insert(new Notice("제목","내용","Y","작성자"));
        Notice notice = noticeRepository.getTestNotice("제목");
        
        notice.update("제목수정","내용수정","N");
        int result = noticeRepository.update(notice);
        Assertions.assertThat(result).isEqualTo(1);
    }
    @Test
    void 공지사항_삭제_성공() {
        noticeRepository.insert(new Notice("제목","내용","Y","작성자"));
        Notice notice = noticeRepository.getTestNotice("제목");

        int result = noticeRepository.delete(notice.getId());
        Assertions.assertThat(result).isEqualTo(1);
    }
}