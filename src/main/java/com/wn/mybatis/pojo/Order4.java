package com.wn.mybatis.pojo;

import java.util.Date;
import java.util.List;

/**
 * 订单-订单详情 1：n
 */
public class Order4 {
    private Integer id;
    private Long userId;
    private String orderNumber;
    private Date created;
    private Date updated;
    private User user;
    private List<OrderDetail2> detailList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail2> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<OrderDetail2> detailList) {
        this.detailList = detailList;
    }

    @Override
    public String toString() {
        return "Order4{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderNumber='" + orderNumber + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", user=" + user +
                ", detailList=" + detailList +
                '}';
    }
}
