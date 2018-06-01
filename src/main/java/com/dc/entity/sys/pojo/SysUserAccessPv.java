package com.dc.entity.sys.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user_access_pv")
public class SysUserAccessPv {
    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_userID")
    private String userid;

    @Column(name = "c_access_time")
    private Date accessTime;

    @Column(name = "c_access_ip")
    private String accessIp;

    @Column(name = "c_source")
    private String source;

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
     * @return c_access_time
     */
    public Date getAccessTime() {
        return accessTime;
    }

    /**
     * @param accessTime
     */
    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    /**
     * @return c_access_ip
     */
    public String getAccessIp() {
        return accessIp;
    }

    /**
     * @param accessIp
     */
    public void setAccessIp(String accessIp) {
        this.accessIp = accessIp;
    }

    /**
     * @return c_source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
    }
}