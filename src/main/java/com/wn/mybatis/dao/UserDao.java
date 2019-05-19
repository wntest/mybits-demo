package com.wn.mybatis.dao;

import com.wn.mybatis.pojo.User;

import java.util.List;

public interface UserDao {

    /**
     * 通过id查询数据
     * @return
     */
    public User queryUserById(String id);

    /**
     * 查询所有数据
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 插入一条数据
     * @param user
     */
    public void insertUser(User user);

    /**
     * 修改数据
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除数据
     * @param id
     */
    public void deleteUser(String id);
}
