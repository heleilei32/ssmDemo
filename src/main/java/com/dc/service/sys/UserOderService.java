package com.dc.service.sys;

import com.dc.entity.sys.dto.TimeInterval;

import java.util.Date;
import java.util.List;

public interface UserOderService {
    List<TimeInterval> select24TimeInterval(Date beginTime, Date endTime, int order_type_succeed);

    int allCount(String userName, int orderResult, Date beginTime, Date endTime, String orderNumber);
}
