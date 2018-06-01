package com.dc.entity.sys.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user_order")
public class SysUserorder {
    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_userID")
    private String userid;

    @Column(name = "c_order_result")
    private Integer orderResult;

    @Column(name = "c_order_time")
    private Date orderTime;

    @Column(name = "c_order_number")
    private String orderNumber;

    @Column(name = "c_order_detail")
    private String orderDetail;

    /**
     * @return c_id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return c_userID
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return c_order_result
     */
    public Integer getOrderResult() {
        return orderResult;
    }

    /**
     * @param orderResult
     */
    public void setOrderResult(Integer orderResult) {
        this.orderResult = orderResult;
    }

    /**
     * @return c_order_time
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * @param orderTime
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * @return c_order_number
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return c_order_detail
     */
    public String getOrderDetail() {
        return orderDetail;
    }

    /**
     * @param orderDetail
     */
    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public static class UserOrderType{

        /**
         * 订购成功
         */
        public static final int Order_Type_Succeed = 1;

        /**
         * 订购失败
         */
        public static final int Order_Type_Fail = 0;

        /**
         * 所有订购的包括成功和失败
         */
        public static final int Order_Type_All = 3;

        /**
         * 退订
         */
        public static final int Order_Type_Unsubscribe = 5;

    }
}