package com.spring.service;

import com.spring.utils.paging.PageHandler;

public interface PagingService {

    PageHandler noticePageHandler(String keyword, int curPage);
    PageHandler storePageHandler(String keyword, int curPage);
}
