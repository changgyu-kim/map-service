package com.spring.repository;

import com.spring.entity.Notice;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoticeRepository {

    private final SqlSession session;

    public NoticeRepository(SqlSession session) {
        this.session = session;
    }

    public String namespace = "com.spring.dao.noticeMapper.";

    public int insert(Notice notice){return session.insert(namespace+"insert",notice);}

    public Notice getTestNotice(String title){return session.selectOne(namespace+"getTestNotice",title);}
    public Notice findById(int id){return session.selectOne(namespace+"findById",id);}
    public List<Notice> findAll(){return session.selectList(namespace+"findAll");}
    public int update(Notice notice) {return session.update(namespace+"update",notice);}
    public int delete(int id) {return session.delete(namespace+"delete",id);}


}
