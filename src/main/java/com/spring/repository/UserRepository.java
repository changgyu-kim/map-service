package com.spring.repository;

import com.spring.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final SqlSession session;

    public UserRepository(SqlSession session) {
        this.session = session;
    }

    public String namespace = "com.spring.dao.userMapper.";

    public int insert(User user){return session.insert(namespace+"insert",user);}
}
