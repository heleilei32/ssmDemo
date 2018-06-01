package com.dc.entity.sys.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sys_admin")
public class SysAdmin {
    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_admin")
    private String admin;

    @Column(name = "c_password")
    private String password;

    @Column(name = "c_time")
    private Date time;

    @Column(name = "c_permissions")
    private String permissions;

    @Column(name = "c_mark")
    private String mark;

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
     * @return c_admin
     */
    public String getAdmin() {
        return admin;
    }

    /**
     * @param admin
     */
    public void setAdmin(String admin) {
        this.admin = admin;
    }

    /**
     * @return c_password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return c_permissions
     */
    public String getPermissions() {
        return permissions;
    }

    /**
     * @param permissions
     */
    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    /**
     * @return c_mark
     */
    public String getMark() {
        return mark;
    }

    /**
     * @param mark
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    public static class SysAdminStatus{
        public static String SESSION_LOGINUSER = "curAdmin";
    }
}