package com.spring.repository;

import com.spring.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SignRepository {

    private SqlSession session;

    private String namespace = "com.spring.dao.signMapper.";

    public SignRepository(SqlSession session) {
        this.session = session;
    }

    public int insert(User user){ return session.insert(namespace+"insert",user);}
    public User findByLogin_id(String login_id){ return session.selectOne(namespace+"findByLogin_id",login_id);}


}
