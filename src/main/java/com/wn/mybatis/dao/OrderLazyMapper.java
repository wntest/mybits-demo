package com.wn.mybatis.dao;

import com.wn.mybatis.pojo.Order;
import com.wn.mybatis.pojo.Order2;
import org.apache.ibatis.annotations.Param;

public interface OrderLazyMapper {
    /**
     * 延时加载
     * @param number 订单编号
     * @return
     */
    Order2 queryOrderAndUserByOrderNumberLazy(@Param("number") String number);
}
