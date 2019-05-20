package com.wn.mybatis.pojo;

import sun.rmi.runtime.Log;

/**
 * 订单详情实体类
 */
public class OrderDetail {
    private Integer id;
    private Integer orderId;
    private Double totalPrice;
    private Integer itemId;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", totalPrice=" + totalPrice +
                ", itemId=" + itemId +
                ", status=" + status +
                '}';
    }
}
