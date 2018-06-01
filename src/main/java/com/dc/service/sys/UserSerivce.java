package com.dc.service.sys;

import java.util.Date;

public interface UserSerivce {
    public int getOldUserOrderCount(int orderType, Date beginTime, Date endTime);

    public int getNewUserOrderCount(int orderType, Date beginTime, Date endTime);
}
