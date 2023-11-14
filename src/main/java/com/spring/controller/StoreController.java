package com.spring.controller;

import com.spring.core.response.ApiResult;
import com.spring.core.response.Result;
import com.spring.entity.Store;
import com.spring.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/stores")
    public ResponseEntity<ApiResult<List<Store>>> getStores(){

        List<Store> stores = storeService.findAll();

        return Result.ok(stores);
    }


}
