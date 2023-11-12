package com.spring.service;

import com.spring.utils.paging.PageHandler;

public interface PagingService {

    PageHandler pageHandler(String keyword, int curPage);
}
