package com.spring.service;

import com.spring.entity.Store;
import com.spring.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
    @Override
    public List<Store> findAll() {

        return storeRepository.findAll();
    }

    @Override
    public List<Store> getStores(String keyword, int curPage, int pageSize) {
        Map map = new HashMap();
        map.put("offset",(curPage-1)*pageSize);
        map.put("pageSize",pageSize);
        if(keyword != null){
            map.put("keyword",keyword);
        }

        return storeRepository.findList(map);
    }
}
