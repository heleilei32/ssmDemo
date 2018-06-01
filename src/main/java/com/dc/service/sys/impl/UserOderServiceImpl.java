package com.dc.service.sys.impl;

import com.dc.Tools.DCLog;
import com.dc.dao.sys.SysUserorderMapper;
import com.dc.entity.sys.dto.TimeInterval;
import com.dc.service.sys.UserOderService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserOderServiceImpl implements UserOderService {

    @Autowired
    SysUserorderMapper sysUserorderMapper;

    @Override
    public List<TimeInterval> select24TimeInterval(Date beginTime, Date endTime, int order_type) {
        return sysUserorderMapper.select24TimeInterval(beginTime,endTime,order_type);
    }

    @Override
    public int allCount(String userName, int orderResult, Date beginTime, Date endTime, String orderNumber) {
        int result = 0;
        try {
            // //////////////////
            result = sysUserorderMapper.allCount(userName, orderResult, beginTime, endTime, orderNumber);
        } catch (Exception e) {
            result = 0;
            DCLog.logException("查询订购集合数量", e);
        }
        return result;
    }
}
