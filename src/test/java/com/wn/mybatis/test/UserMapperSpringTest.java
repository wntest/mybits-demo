package com.wn.mybatis.test;

import com.wn.mybatis.dao.UserMapper;
import com.wn.mybatis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class) //junit整合spring的测试//立马开启了spring的注解
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")//加载核心配置文件，自动构建spring容器
public class UserMapperSpringTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void login() {
        User user = userMapper.login("wn","123456");
        System.out.println(user);
    }

    @Test
    public void queryUserByTableName() {
        List<User> userList = this.userMapper.queryUserByTableName("tb_user");
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void queryUserById() {
        System.out.println(userMapper.queryUserById("1"));
    }

    @Test
    public void queryUserAll() {
        List<User> userList = userMapper.queryUserAll();
        userList.stream().forEach(user -> System.out.println(user));
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setAge(20);
        user.setBirthday(new Date());
        user.setName("大神");
        user.setPassword("123456");
        user.setSex(2);
        user.setUserName("bigGod222");
        this.userMapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("静静");
        user.setPassword("123456");
        user.setSex(0);
        user.setUserName("Jinjin");
        user.setId(1);
        this.userMapper.updateUser(user);
    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void querySomeUsers() {
    }

    @Test
    public void searchUsers() {
    }

    @Test
    public void searchUsers2() {
    }

    @Test
    public void findAllUser() {
    }
}