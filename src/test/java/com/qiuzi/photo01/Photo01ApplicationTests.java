package com.qiuzi.photo01;

import com.qiuzi.photo01.bean.User;
import com.qiuzi.photo01.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Photo01ApplicationTests {

//    private InputStream in;
//    private SqlSessionFactory factory;
//    private SqlSession sqlSession;
//    private UserMapper userMapper;
//
//    @Before
//    public void init() throws Exception {
//        in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        factory = new SqlSessionFactoryBuilder().build(in);
//        sqlSession = factory.openSession();
//        userMapper = sqlSession.getMapper(UserMapper.class);
//    }
//
//    @After
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
