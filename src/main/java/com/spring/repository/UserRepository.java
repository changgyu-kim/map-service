package com.spring.repository;

import com.spring.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final SqlSession session;

    public UserRepository(SqlSession session) {
        this.session = session;
    }

    public String namespace = "com.spring.dao.userMapper.";

    public User findById(int id){return session.selectOne(namespace+"findById",id);}

    public int update(User user){return session.update(namespace+"update",user);}

    public int delete(int id){return session.delete(namespace+"delete",id);}

}
