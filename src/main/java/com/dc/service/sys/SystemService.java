package com.dc.service.sys;

import com.dc.entity.sys.pojo.SysAdmin;

public interface SystemService {

    /**
     * 查询一个管理员
     * @param sysAdmin
     * @return
     */
    public SysAdmin selectOne(SysAdmin sysAdmin);


}
