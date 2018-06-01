package com.dc.dao.sys;

import com.dc.entity.sys.dto.TimeInterval;
import com.dc.entity.sys.pojo.SysUserorder;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface SysUserorderMapper extends Mapper<SysUserorder> {

    /**
     * 查询24小时的时间间隔数据
     *
     * @date 2017-11-4 下午5:23:02
     * @author cao_xue_yong
     * @param beginTime
     * @param endTime
     * @param orderResult
     * @return
     */
    public List<TimeInterval> select24TimeInterval(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime, @Param("orderResult") int orderResult);

    /**
     * 查询集合数量
     *
     * @date 2017-8-25 下午4:41:09
     * @author cao_xue_yong
     * @param userName
     * @param orderResult
     * @param beginTime
     * @param endTime
     * @param orderNumber
     * @return
     */
    public int allCount(@Param("userName") String userName, @Param("orderResult") int orderResult, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime, @Param("orderNumber") String orderNumber);
}