package com.spring.repository;

import com.spring.entity.Store;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreRepository {
    private final SqlSession session;

    public StoreRepository(SqlSession session) {
        this.session = session;
    }

    public String namespace = "com.spring.dao.storeMapper.";


    public int insertList(List<Store> storeList){return session.insert(namespace+"insertList",storeList);}

}
