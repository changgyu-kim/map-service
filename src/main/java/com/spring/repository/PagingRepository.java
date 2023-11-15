package com.spring.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PagingRepository {
    private final SqlSession session;

    public PagingRepository(SqlSession session) {
        this.session = session;
    }

    public String namespace = "com.spring.dao.pagingMapper.";


    public int noticeCountAll(String keyword){return session.selectOne(namespace+"noticeCountAll",keyword);}
    public int storeCountAll(String keyword){return session.selectOne(namespace+"storeCountAll",keyword);}

}
