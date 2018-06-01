package com.dc.dao.sys;

import com.dc.entity.sys.dto.TimeInterval;
import com.dc.entity.sys.pojo.SysUserAccessPv;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface SysUserAccessPvMapper extends Mapper<SysUserAccessPv> {

    /**
     * 查询PV24小时的时间间隔数据
     *
     * @date 2017-11-4 下午5:23:02
     * @author cao_xue_yong
     * @param beginTime
     * @param endTime
     * @return
     */
    public List<TimeInterval> select24TimeInterval(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);



    /**
     * 查询集合数量
     *
     * @date 2017-8-28 下午8:47:22
     * @author cao_xue_yong
     * @param source
     * @param userName
     * @param ip
     * @param beginTime
     * @param endTime
     * @return
     */
    public int allCount(@Param("source") String source, @Param("userName") String userName, @Param("ip") String ip, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);


    /**
     * 更具pv数量得到uv数量
     *
     * @date 2017-11-3 下午7:27:11
     * @author cao_xue_yong
     * @param beginTime
     * @param endTime
     * @return
     */
    public int accordingToPVGetsUV(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}