package com.wn.mybatis.test;

import com.wn.mybatis.dao.OrderMapper;
import com.wn.mybatis.pojo.Order2;
import com.wn.mybatis.pojo.Order3;
import com.wn.mybatis.pojo.Order4;
import com.wn.mybatis.pojo.OrderUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class OrderMapperTest {

    private OrderMapper orderMapper;

    @Before
    public void setUp() throws Exception {
        // 全局配置文件路径
        String resources = "mybatis-config.xml";
        // 加载资源
        InputStream inputStream = Resources.getResourceAsStream(resources);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过映射获取OrderMapper对象
        this.orderMapper = sqlSession.getMapper(OrderMapper.class);

    }

    @Test
    public void queryOrderUserByOrderNumber() {
        OrderUser orderUser = orderMapper.queryOrderUserByOrderNumber("201807010001");
        System.out.println(orderUser);
    }

    @Test
    public void queryOrderWithUserByOrderNumber() {
        Order2 order2 = orderMapper.queryOrderWithUserByOrderNumber("201807010001");
        System.out.println(order2);
    }

    @Test
    public void queryOrderWithUserAndDetailByOrderNumber() {
        Order3 order3 = orderMapper.queryOrderWithUserAndDetailByOrderNumber("201807010001");
        System.out.println(order3);
        System.out.println(order3.getDetailList().size());
    }

    @Test
    public void queryOrderWithUserAndDetailItemByOrderNumber() {
        List<Order4> list = orderMapper.queryOrderWithUserAndDetailItemByOrderNumber("201807010001");
        System.out.println(list);
    }
}