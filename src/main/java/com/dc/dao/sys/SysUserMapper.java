package com.dc.dao.sys;

import com.dc.entity.sys.pojo.SysUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;

public interface SysUserMapper extends Mapper<SysUser> {

    /**
     * 得到老用户数的订购数量，orderType == -1,代表老的用户量
     *
     * @date 2017-11-4 下午1:10:41
     * @author cao_xue_yong
     * @param orderType
     * @param beginTime
     * @param endTime
     * @return
     */
    public int getOldUserOrderCount(@Param("orderType") int orderType, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    /**
     * 得到新用户的订购数量 orderType == -1,代表新用户量
     *
     * @date 2017-11-4 下午1:10:25
     * @author cao_xue_yong
     * @param orderType
     * @param beginTime
     * @param endTime
     * @return
     */
    public int getNewUserOrderCount(@Param("orderType") int orderType, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}