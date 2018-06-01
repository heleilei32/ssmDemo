package com.dc.service.sys.impl;

import com.dc.Tools.DCLog;
import com.dc.dao.sys.SysUserAccessPvMapper;
import com.dc.entity.sys.dto.TimeInterval;
import com.dc.service.sys.UserAccessPVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserAccessPVServiceImpl implements UserAccessPVService {
    @Autowired
    SysUserAccessPvMapper sysUserAccessPvMapper;


    @Override
    public List<TimeInterval> select24TimeInterval(Date beginTime, Date endTime) {
        return sysUserAccessPvMapper.select24TimeInterval(beginTime,endTime);
    }

    @Override
    public int allCount(String source, String userName, String ip, Date beginTime, Date endTime) {
        int result = 0;
        try {
            // //////////////////
            result = sysUserAccessPvMapper.allCount(source, userName, ip, beginTime, endTime);
        } catch (Exception e) {
            result = 0;
            DCLog.logException("查询用户访问pv集合数量", e);
        }
        return result;
    }

    @Override
    public int accordingToPVGetsUV(Date beginTime, Date endTime) {
        int result = 0;
        try {
            // //////////////////
            result = sysUserAccessPvMapper.accordingToPVGetsUV(beginTime, endTime);
        } catch (Exception e) {
            result = 0;
            DCLog.logException("根据pv数量得到uv数量", e);
        }
        return result;
    }
}
