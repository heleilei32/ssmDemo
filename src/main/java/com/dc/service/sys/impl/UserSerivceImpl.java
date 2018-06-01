package com.dc.service.sys.impl;

import com.dc.Tools.DCLog;
import com.dc.Tools.StaticParameter;
import com.dc.dao.sys.SysUserMapper;
import com.dc.service.sys.UserSerivce;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserSerivceImpl implements UserSerivce {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public int getOldUserOrderCount(int orderType, Date beginTime, Date endTime) {
        if (orderType != StaticParameter.Order_Type_Succeed && orderType != StaticParameter.Order_Type_Fail) {
            orderType = StaticParameter.Order_Type_Fail;
        }
        int result = 0;
        try {
            // //////////////////
            result = sysUserMapper.getOldUserOrderCount(orderType, beginTime, endTime);
        } catch (Exception e) {
            result = 0;
            DCLog.logException("得到老用户数的订购数量", e);
        }
        return result;
    }

    @Override
    public int getNewUserOrderCount(int orderType, Date beginTime, Date endTime) {
        // 只能是成功或者失败的
        if (orderType != StaticParameter.Order_Type_Succeed && orderType != StaticParameter.Order_Type_Fail) {
            orderType = StaticParameter.Order_Type_Fail;
        }
        int result = 0;
        try {
            result = sysUserMapper.getNewUserOrderCount(orderType, beginTime, endTime);
        } catch (Exception e) {
            result = 0;
            DCLog.logException("得到新用户的订购数量", e);
        }
        return result;
    }
}
