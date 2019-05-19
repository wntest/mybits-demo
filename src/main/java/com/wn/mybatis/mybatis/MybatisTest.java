package com.wn.mybatis.mybatis;

import com.wn.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        // 指定全局配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();


        User user = null;
        try {
            // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
            // 第二个参数：指定传入sql的参数：这里是用户id
            user = sqlSession.selectOne("MyMapper.selectUser", 1);
            System.out.println(user);
        } catch (Exception e) {
            sqlSession.close();
        }

    }
}
