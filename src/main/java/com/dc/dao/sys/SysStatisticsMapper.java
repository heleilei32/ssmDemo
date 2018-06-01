package com.dc.dao.sys;

import com.dc.entity.sys.pojo.SysStatistics;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface SysStatisticsMapper extends Mapper<SysStatistics> {

    /**
     * 查询统计集合的数量
     *
     * @date 2017-9-19 下午6:04:01
     * @author cao_xue_yong
     * @param type
     *            ，年月日
     * @param beginTime
     * @param endTime
     * @return
     */
    public int allCount(@Param("type") int type, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);



    /**
     * 查询统计集合
     *
     * @date 2017-9-19 下午6:03:44
     * @author cao_xue_yong
     * @param type
     * @param beginTime
     * @param endTime
     * @param index
     * @param count
     * @return
     */
    public List<SysStatistics> select1(@Param("type") int type, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime, @Param("index") int index, @Param("count") int count);
}