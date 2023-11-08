package com.spring.repository;

import com.spring.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class SignRepository {

    private SqlSession session;

    private String namespace = "com.spring.dao.signMapper.";

    public SignRepository(SqlSession session) {
        this.session = session;
    }

    public int insert(User user){ return session.insert(namespace+"insert",user);}
    public User findByLoginId(String loginId){ return session.selectOne(namespace+"findByLoginId",loginId);}


}
