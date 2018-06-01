package com.dc.service.sys;

import com.dc.entity.sys.pojo.SysStatistics;

import java.util.Date;
import java.util.List;

public interface SysStatisticsService {
    int allCount(int type, Date beginTime, Date endTime);

    List<SysStatistics> select(int type, Date beginTime, Date endTime, int i, int i1);
}
