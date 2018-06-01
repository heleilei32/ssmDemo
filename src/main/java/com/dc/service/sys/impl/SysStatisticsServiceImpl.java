package com.dc.service.sys.impl;


import com.dc.Tools.DCLog;
import com.dc.Tools.StaticParameter;
import com.dc.Tools.Tools;
import com.dc.dao.sys.SysStatisticsMapper;
import com.dc.entity.sys.pojo.SysStatistics;
import com.dc.service.sys.SysStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysStatisticsServiceImpl implements SysStatisticsService {
    @Autowired
    SysStatisticsMapper sysStatisticsMapper;



    @Override
    public int allCount(int type, Date beginTime, Date endTime) {
        int result = 0;
        // 查询的时间规范调整
        if (StaticParameter.Statistics_Type_Day == type) {
            //
            beginTime = Tools.getStartingTime(beginTime);
            endTime = Tools.getEndingTime(endTime);
        } else if (StaticParameter.Statistics_Type_Month == type) {
            //
            beginTime = Tools.getMonthBeginTime(beginTime);
            endTime = Tools.getMonthEndTime(endTime);
        } else if (StaticParameter.Statistics_Type_Year == type) {
            //
            beginTime = Tools.getYearBeginTime(beginTime);
            endTime = Tools.getYearEndTime(endTime);
        }
        try {
            result = sysStatisticsMapper.allCount(type, beginTime, endTime);
        } catch (Exception e) {
            result = 0;
            DCLog.logException("获得统计信息的数量", e);
        }
        return result;
    }

    @Override
    public List<SysStatistics> select(int type, Date beginTime, Date endTime, int index, int count) {
        List<SysStatistics> list = null;
        // 查询的时间规范调整
        if (StaticParameter.Statistics_Type_Day == type) {
            //
            beginTime = Tools.getStartingTime(beginTime);
            endTime = Tools.getEndingTime(endTime);
        } else if (StaticParameter.Statistics_Type_Month == type) {
            //
            beginTime = Tools.getMonthBeginTime(beginTime);
            endTime = Tools.getMonthEndTime(endTime);
        } else if (StaticParameter.Statistics_Type_Year == type) {
            //
            beginTime = Tools.getYearBeginTime(beginTime);
            endTime = Tools.getYearEndTime(endTime);
        }
        try {
            list = sysStatisticsMapper.select1(type, beginTime, endTime, index, count);
        } catch (Exception e) {
            list = null;
            DCLog.logException("获得统计信息的集合", e);
        }
        return list;
    }
}
