package com.dc.service.sys.impl;

import com.dc.dao.sys.SysUserAccessUvMapper;
import com.dc.entity.sys.dto.TimeInterval;
import com.dc.service.sys.UserAccessUVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserAccessUVServiceImpl implements UserAccessUVService {
    @Autowired
    SysUserAccessUvMapper sysUserAccessUvMapper;


    @Override
    public List<TimeInterval> selectUV24TimeInterval(Date beginTime, Date endTime) {
        return sysUserAccessUvMapper.selectUV24TimeInterval(beginTime,endTime);
    }
}
