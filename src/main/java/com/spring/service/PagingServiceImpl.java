package com.spring.service;

import com.spring.repository.PagingRepository;
import com.spring.utils.paging.PageHandler;
import org.springframework.stereotype.Service;

@Service
public class PagingServiceImpl implements PagingService{

    private final PagingRepository pagingRepository;

    public PagingServiceImpl(PagingRepository pagingRepository) {
        this.pagingRepository = pagingRepository;
    }

    @Override
    public PageHandler noticePageHandler(String keyword, int curPage) {

        int totalPage = pagingRepository.noticeCountAll(keyword);

        return new PageHandler(totalPage,curPage);
    }
    @Override
    public PageHandler storePageHandler(String keyword, int curPage) {

        int totalPage = pagingRepository.storeCountAll(keyword);

        return new PageHandler(totalPage,curPage);
    }
}
