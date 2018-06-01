package com.dc.service.sys.impl;

import com.dc.dao.sys.SysAdminMapper;
import com.dc.entity.sys.pojo.SysAdmin;
import com.dc.service.sys.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    SysAdminMapper sysAdminMapper;


    @Override
    public SysAdmin selectOne(SysAdmin sysAdmin) {
        return sysAdminMapper.selectOne(sysAdmin);
    }
}
