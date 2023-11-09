package com.spring.service;

import com.spring.controller.dto.NoticeCreateDto;
import com.spring.controller.dto.NoticeUpdateDto;
import com.spring.core.exception.ExceptionCode;
import com.spring.entity.Notice;
import com.spring.entity.User;
import com.spring.repository.NoticeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.spring.core.exception.CustomException.validate;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService{

    private final NoticeRepository noticeRepository;

    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public int create(NoticeCreateDto dto, User user) {

        Notice notice = new Notice(dto.getTitle(), dto.getContent(), dto.getSecret(), user.getLoginId());
        return noticeRepository.insert(notice);
    }

    @Override
    public Notice getOneNotice(int id) {
        Notice notice = noticeRepository.findById(id);
        validate(notice != null, ExceptionCode.NOT_FOUND_NOTICE);

        return notice;
    }

    @Override
    public List<Notice> getNotices() {
        return null;
    }

    @Override
    public Notice update(int id, NoticeUpdateDto dto) {
        Notice notice = noticeRepository.findById(id);
        validate(notice != null, ExceptionCode.NOT_FOUND_NOTICE);
        notice.update(dto.getTitle(), dto.getContent(), dto.getSecret());
        noticeRepository.update(notice);

        return notice;
    }

    @Override
    public int delete(int id) {

        return noticeRepository.delete(id);
    }
}
