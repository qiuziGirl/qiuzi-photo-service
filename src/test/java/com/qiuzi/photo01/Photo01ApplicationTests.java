package com.qiuzi.photo01;

import com.qiuzi.photo01.bean.User;
import com.qiuzi.photo01.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
public class Photo01ApplicationTests {

//    private InputStream in;
//    private SqlSessionFactory factory;
//    private SqlSession sqlSession;
//    private UserMapper userMapper;
//
//    @BeforeEach
//    public void init() throws Exception {
//        in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        factory = new SqlSessionFactoryBuilder().build(in);
//        sqlSession = factory.openSession();
//        userMapper = sqlSession.getMapper(UserMapper.class);
//    }
//
//    @AfterEach
//    public void destory() throws Exception {
//        sqlSession.commit();
//        sqlSession.close();
//        in.close();
//    }
//
//    @Test
//    public void testFindAll() {
//        List<User> users = userMapper.findAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
//    }

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
