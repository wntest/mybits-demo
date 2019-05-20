package com.wn.mybatis.dao;

import com.wn.mybatis.pojo.Order2;
import com.wn.mybatis.pojo.Order3;
import com.wn.mybatis.pojo.Order4;
import com.wn.mybatis.pojo.OrderUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    OrderUser queryOrderUserByOrderNumber(@Param("number") String number);

    Order2 queryOrderWithUserByOrderNumber(@Param("number") String number);

    Order3 queryOrderWithUserAndDetailByOrderNumber(@Param("number") String number);

    List<Order4> queryOrderWithUserAndDetailItemByOrderNumber(@Param("number") String number);
}
