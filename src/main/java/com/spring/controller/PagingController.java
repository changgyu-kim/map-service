package com.spring.controller;

import com.spring.core.response.ApiResult;
import com.spring.core.response.Result;
import com.spring.service.PagingService;
import com.spring.utils.paging.PageHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagingController {

    private final PagingService pagingService;

    public PagingController(PagingService pagingService) {
        this.pagingService = pagingService;
    }

    @GetMapping("/notice-paging")
    public ResponseEntity<ApiResult<PageHandler>> noticePaging(@RequestParam(required = false) String keyword ,
                                               @RequestParam(defaultValue = "1") int curPage){

        PageHandler pageHandler = pagingService.noticePageHandler(keyword, curPage);
        return Result.ok(pageHandler);
    }
    @GetMapping("/store-paging")
    public ResponseEntity<ApiResult<PageHandler>> storePaging(@RequestParam(required = false) String keyword ,
                                                         @RequestParam(defaultValue = "1") int curPage){

        PageHandler pageHandler = pagingService.storePageHandler(keyword, curPage);
        return Result.ok(pageHandler);
    }
}
