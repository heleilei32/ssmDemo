package com.dc.service.sys;

import com.dc.entity.sys.dto.TimeInterval;

import java.util.Date;
import java.util.List;

public interface UserAccessUVService {
    List<TimeInterval> selectUV24TimeInterval(Date beginTime, Date endTime);
}
