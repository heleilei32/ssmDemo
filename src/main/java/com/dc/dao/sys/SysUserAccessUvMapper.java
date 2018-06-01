package com.dc.dao.sys;

import com.dc.entity.sys.dto.TimeInterval;
import com.dc.entity.sys.pojo.SysUserAccessUv;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface SysUserAccessUvMapper extends Mapper<SysUserAccessUv> {

    /**
     * 查询UV24小时的时间间隔数据
     *
     * @date 2017-11-4 下午5:23:02
     * @author cao_xue_yong
     * @param beginTime
     * @param endTime
     * @return
     */
    public List<TimeInterval> selectUV24TimeInterval(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}