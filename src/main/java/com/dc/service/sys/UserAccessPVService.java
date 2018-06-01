package com.dc.service.sys;

import com.dc.entity.sys.dto.TimeInterval;

import java.util.Date;
import java.util.List;

public interface UserAccessPVService {
    /**
     * 根据pv查询PV24小时的时间间隔数据
     * @param beginTime
     * @param endTime
     * @return
     */
    List<TimeInterval> select24TimeInterval(Date beginTime, Date endTime);

    public int allCount(String source, String userName, String ip, Date beginTime, Date endTime);


    public int accordingToPVGetsUV(Date beginTime, Date endTime);
}
