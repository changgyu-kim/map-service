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


    public int countAll(String keyword){return session.selectOne(namespace+"countAll",keyword);}

}
