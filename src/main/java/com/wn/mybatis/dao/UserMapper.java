package com.wn.mybatis.dao;

import com.wn.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 登录（使用注解指定参数传入的名称）
     * @param userName
     * @param password
     * @return
     */
    User login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 根据表名查询用户信息
     * @param tableName
     * @return
     */
    List<User> queryUserByTableName(@Param("tableName") String tableName);

    User queryUserById(String id);

    /**
     * 查询所有数据
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
    public void deleteUserById(String id);

    /**
     * foreach
     * @param names
     * @return
     */
    List<User> querySomeUsers(@Param("names") List<String> names);

    /**
     * where
     * @param user
     * @return
     */
    List<User> searchUsers(User user);

    /**
     * when
     * @param user
     * @return
     */
    List<User> searchUsers2(User user);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUser();
}
