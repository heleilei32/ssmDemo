package com.dc.entity.sys.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sys_statistics")
public class SysStatistics {
    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_type")
    private Integer type;

    @Column(name = "c_time")
    private Date time;

    @Column(name = "c_uv")
    private Integer uv;

    @Column(name = "c_pv")
    private Integer pv;

    @Column(name = "c_old_user_order")
    private Integer oldUserOrder;

    @Column(name = "c_old_user_no_order")
    private Integer oldUserNoOrder;

    @Column(name = "c_new_user_order")
    private Integer newUserOrder;

    @Column(name = "c_new_user_no_order")
    private Integer newUserNoOrder;

    @Column(name = "c_new_user_probability")
    private Float newUserProbability;

    @Column(name = "c_send_order_count")
    private Integer sendOrderCount;

    @Column(name = "c_order_succeed_count")
    private Integer orderSucceedCount;

    @Column(name = "c_unsubscribe_count")
    private Integer unsubscribeCount;

    @Column(name = "c_order_probability")
    private Float orderProbability;

    @Column(name = "c_month_user_arrive_mz")
    private Integer monthUserArriveMz;

    @Column(name = "c_month_user_arrive_jz")
    private Integer monthUserArriveJz;

    @Column(name = "c_detail")
    private String detail;

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
     * @return c_type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return c_time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * @return c_uv
     */
    public Integer getUv() {
        return uv;
    }

    /**
     * @param uv
     */
    public void setUv(Integer uv) {
        this.uv = uv;
    }

    /**
     * @return c_pv
     */
    public Integer getPv() {
        return pv;
    }

    /**
     * @param pv
     */
    public void setPv(Integer pv) {
        this.pv = pv;
    }

    /**
     * @return c_old_user_order
     */
    public Integer getOldUserOrder() {
        return oldUserOrder;
    }

    /**
     * @param oldUserOrder
     */
    public void setOldUserOrder(Integer oldUserOrder) {
        this.oldUserOrder = oldUserOrder;
    }

    /**
     * @return c_old_user_no_order
     */
    public Integer getOldUserNoOrder() {
        return oldUserNoOrder;
    }

    /**
     * @param oldUserNoOrder
     */
    public void setOldUserNoOrder(Integer oldUserNoOrder) {
        this.oldUserNoOrder = oldUserNoOrder;
    }

    /**
     * @return c_new_user_order
     */
    public Integer getNewUserOrder() {
        return newUserOrder;
    }

    /**
     * @param newUserOrder
     */
    public void setNewUserOrder(Integer newUserOrder) {
        this.newUserOrder = newUserOrder;
    }

    /**
     * @return c_new_user_no_order
     */
    public Integer getNewUserNoOrder() {
        return newUserNoOrder;
    }

    /**
     * @param newUserNoOrder
     */
    public void setNewUserNoOrder(Integer newUserNoOrder) {
        this.newUserNoOrder = newUserNoOrder;
    }

    /**
     * @return c_new_user_probability
     */
    public Float getNewUserProbability() {
        return newUserProbability;
    }

    /**
     * @param newUserProbability
     */
    public void setNewUserProbability(Float newUserProbability) {
        this.newUserProbability = newUserProbability;
    }

    /**
     * @return c_send_order_count
     */
    public Integer getSendOrderCount() {
        return sendOrderCount;
    }

    /**
     * @param sendOrderCount
     */
    public void setSendOrderCount(Integer sendOrderCount) {
        this.sendOrderCount = sendOrderCount;
    }

    /**
     * @return c_order_succeed_count
     */
    public Integer getOrderSucceedCount() {
        return orderSucceedCount;
    }

    /**
     * @param orderSucceedCount
     */
    public void setOrderSucceedCount(Integer orderSucceedCount) {
        this.orderSucceedCount = orderSucceedCount;
    }

    /**
     * @return c_unsubscribe_count
     */
    public Integer getUnsubscribeCount() {
        return unsubscribeCount;
    }

    /**
     * @param unsubscribeCount
     */
    public void setUnsubscribeCount(Integer unsubscribeCount) {
        this.unsubscribeCount = unsubscribeCount;
    }

    /**
     * @return c_order_probability
     */
    public Float getOrderProbability() {
        return orderProbability;
    }

    /**
     * @param orderProbability
     */
    public void setOrderProbability(Float orderProbability) {
        this.orderProbability = orderProbability;
    }

    /**
     * @return c_month_user_arrive_mz
     */
    public Integer getMonthUserArriveMz() {
        return monthUserArriveMz;
    }

    /**
     * @param monthUserArriveMz
     */
    public void setMonthUserArriveMz(Integer monthUserArriveMz) {
        this.monthUserArriveMz = monthUserArriveMz;
    }

    /**
     * @return c_month_user_arrive_jz
     */
    public Integer getMonthUserArriveJz() {
        return monthUserArriveJz;
    }

    /**
     * @param monthUserArriveJz
     */
    public void setMonthUserArriveJz(Integer monthUserArriveJz) {
        this.monthUserArriveJz = monthUserArriveJz;
    }

    /**
     * @return c_detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}