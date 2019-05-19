package com.wn.mybatis.test;

import com.wn.mybatis.dao.UserDao;
import com.wn.mybatis.dao.impl.UserDaoImpl;
import com.wn.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

    public UserDao userDao;
    public SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession
        this.sqlSession = sqlSessionFactory.openSession();
        this.userDao = new UserDaoImpl(sqlSession);
    }

    @Test
    public void queryUserById() {
        String id = "1";
        User user = userDao.queryUserById(id);
        System.out.println(user);
    }

    @Test
    public void queryUserAll() {
        List<User> users = userDao.queryUserAll();
        for (User user: users) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setId("4");
        user.setUserName("lisi");
        user.setPassword("123456");
        user.setAge(11);
        Calendar calendar = Calendar.getInstance();
        calendar.set(1995,10,11);
        user.setBirthday(calendar.getTime());
        user.setName("李四");
        user.setSex(1);
        userDao.insertUser(user);
        sqlSession.commit();
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId("3");
        user.setUserName("lisi2");
        user.setPassword("123456");
        user.setAge(11);
        Calendar calendar = Calendar.getInstance();
        calendar.set(1995,11,11);
        user.setBirthday(calendar.getTime());
        user.setName("李四");
        user.setSex(1);

        userDao.updateUser(user);
        sqlSession.commit();
    }

    @Test
    public void deleteUser() {
        String id =  "3";
        userDao.deleteUser(id);
        sqlSession.commit();
    }
}