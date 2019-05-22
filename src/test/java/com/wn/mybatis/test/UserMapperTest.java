package com.wn.mybatis.test;

import com.wn.mybatis.dao.UserMapper;
import com.wn.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class UserMapperTest {

    public UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        //
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //  构建 sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 1. 映射文件的命名空间（namespace）必须是mapper接口的全路径
        // 2. 映射文件的statement的id必须和mapper接口的方法名保持一致
        // 3. Statement的resultType必须和mapper接口方法的返回类型一致
        // 4. statement的parameterType必须和mapper接口方法的参数类型一致（不一定）
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void login() {
        System.out.println(this.userMapper.login("wn","123456"));
        System.out.println(this.userMapper.login("wn","123456"));
    }

    @Test
    public void queryUserByTableName() {
        List<User> userList = userMapper.queryUserByTableName("tb_user");
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void queryById() {
        User user = userMapper.queryUserById("4");
        System.out.println(user);
    }

    @Test
    public void queryUserAll() {
        List<User> userList = userMapper.queryUserAll();
        userList = userList.stream().filter(user -> !"1".equals(user.getId())).collect(Collectors.toList());
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setId(5);
        user.setUserName("lisi2");
        user.setPassword("123456");
        user.setName("李四2");
        user.setSex(1);
        user.setAge(22);
        LocalDate localDate = LocalDate.of(1005,11,11);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        user.setBirthday(date);
        System.out.println(user);
        userMapper.insertUser(user);
        System.out.println("userId:" + user.getId());
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setAge(24);
        user.setName("李四3");
        user.setUserName("lisi3");
        user.setId(4);
        userMapper.updateUser(user);
    }

    @Test
    public void deleteUserById() {
        userMapper.deleteUserById("4");
    }

    @Test
    public void searchUsers() {
        User user = new User();
//        user.setUserName("zs");
//        user.setAge(22);
        List<User> users = userMapper.searchUsers(user);
        users.forEach(user2 -> System.out.println(user2));
    }

    @Test
    public void searchUsers2() {
        User user = new User();
        user.setUserName("zs");
        user.setAge(23);
        List<User> users = userMapper.searchUsers2(user);
        users.forEach(user2 -> System.out.println(user2));
    }

    @Test
    public void querySomeUsers() {
        List<String> names = new ArrayList<String >();
        names.add("zs");
        names.add("wn");
        List<User> userList = userMapper.querySomeUsers(names);
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void findAllUser() {
        List<User> list = userMapper.findAllUser();
        list.forEach((user) -> {
            System.out.println(user);
        });
    }
}