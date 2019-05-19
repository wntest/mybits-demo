package com.wn.mybatis.dao.impl;

import com.wn.mybatis.dao.UserDao;
import com.wn.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User queryUserById(String id) {
        return this.sqlSession.selectOne("UserDao.queryUserById", id);
    }

    public List<User> queryUserAll() {
        return this.sqlSession.selectList("UserDao.queryUserAll");
    }

    public void insertUser(User user) {
        this.sqlSession.insert("UserDao.insertUser", user);
    }

    public void updateUser(User user) {
        System.out.println(user);
        this.sqlSession.update("UserDao.updateUser", user);
    }

    public void deleteUser(String id) {
        this.sqlSession.delete("UserDao.deleteUser", id);
    }
}
