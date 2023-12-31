package com.spring.service;

import com.spring.entity.Store;

import java.util.List;

public interface StoreService {

    List<Store> findAll();
    List<Store> getStores(String keyword, int curPage, int pageSize);

}
