package com.spring.repository;

import com.spring.entity.Store;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class StoreRepository {
    private final SqlSession session;

    public StoreRepository(SqlSession session) {
        this.session = session;
    }

    public String namespace = "com.spring.dao.storeMapper.";


    public int insert(Store store){return session.insert(namespace+"insert",store);}

}
