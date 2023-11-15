package com.spring.repository;

import com.spring.entity.Store;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StoreRepository {
    private final SqlSession session;

    public StoreRepository(SqlSession session) {
        this.session = session;
    }

    public String namespace = "com.spring.dao.storeMapper.";

    public int insertList(List<Store> storeList){return session.insert(namespace+"insertList",storeList);}

    public List<Store> findAll(){return session.selectList(namespace+"findAll");}

    public List<Store> findList(Map map){return session.selectList(namespace+"findList",map);}

}
