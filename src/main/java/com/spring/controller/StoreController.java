package com.spring.controller;

import com.spring.core.response.ApiResult;
import com.spring.core.response.Result;
import com.spring.entity.Store;
import com.spring.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    // 맵에서 사용할 api
    @GetMapping("/stores")
    public ResponseEntity<ApiResult<List<Store>>> getStores(){

        List<Store> stores = storeService.findAll();

        return Result.ok(stores);
    }

    // 매장리스트에서 사용할 api
    @GetMapping("/storeList")
    public ResponseEntity<ApiResult<List<Store>>> getNotices(@RequestParam(required = false) String keyword ,
                                                              @RequestParam(defaultValue = "1") int curPage,
                                                              @RequestParam(defaultValue = "5") int pageSize){
        List<Store> stores = storeService.getStores(keyword, curPage, pageSize);

        return Result.ok(stores);
    }


}
