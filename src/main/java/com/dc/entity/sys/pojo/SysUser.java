package com.dc.entity.sys.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_userID")
    private String userid;

    @Column(name = "c_ip")
    private String ip;

    @Column(name = "c_login_time")
    private Date loginTime;

    @Column(name = "c_order_user")
    private Boolean orderUser;

    @Column(name = "c_first_record")
    private Date firstRecord;

    @Column(name = "c_ordered")
    private Boolean ordered;

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
     * @return c_ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return c_login_time
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * @param loginTime
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * @return c_order_user
     */
    public Boolean getOrderUser() {
        return orderUser;
    }

    /**
     * @param orderUser
     */
    public void setOrderUser(Boolean orderUser) {
        this.orderUser = orderUser;
    }

    /**
     * @return c_first_record
     */
    public Date getFirstRecord() {
        return firstRecord;
    }

    /**
     * @param firstRecord
     */
    public void setFirstRecord(Date firstRecord) {
        this.firstRecord = firstRecord;
    }

    /**
     * @return c_ordered
     */
    public Boolean getOrdered() {
        return ordered;
    }

    /**
     * @param ordered
     */
    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }
}