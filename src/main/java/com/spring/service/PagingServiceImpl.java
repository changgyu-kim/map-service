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
    public PageHandler pageHandler(String keyword, int curPage) {

        int totalPage = pagingRepository.countAll(keyword);

        return new PageHandler(totalPage,curPage);

    }
}
