package com.wn.mybatis.test;

import com.wn.mybatis.dao.OrderLazyMapper;
import com.wn.mybatis.pojo.Order;
import com.wn.mybatis.pojo.Order2;
import com.wn.mybatis.pojo.Order4;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class OrderLazyMapperTest {

    private OrderLazyMapper orderLazyMapper;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        this.orderLazyMapper = sqlSession.getMapper(OrderLazyMapper.class);
    }

    @Test
    public void queryOrderAndUserByOrderNumberLazy() {
        Order2 order = orderLazyMapper.queryOrderAndUserByOrderNumberLazy("201807010001");
        System.out.println(order);
        System.out.println(order.getOrderNumber());
        System.out.println("===========================");
        System.out.println(order.getUser());
    }
}