package com.spring.connection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/applicationContext.xml"})
public class ConnectionTest {
    @Autowired
    DataSource ds;

    @Test
    public void DB연동_성공() throws Exception {

        Connection conn = null;

        try {
            //드라이버 연결
            //접속 URL, mysql 유저 아이디, 비밀번호로 접속
            conn = ds.getConnection();

            //접속성공 메세지
            System.out.println("Database connection established");
        } catch (Exception e) {

            //예외 발생시 메세지
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();

                    System.out.println("Database Connection Terminated");
                } catch (Exception e) {}
            }
        }
    }


}
