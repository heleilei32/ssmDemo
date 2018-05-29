package com.dc.controller;

import com.dc.dao.ExtendUserKeyMapper;
import com.dc.entity.pojo.ExtendUserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class main {

    @Autowired
    ExtendUserKeyMapper extendUserKeyMapper;


    @RequestMapping("/1")
    @ResponseBody
    public String index(){
        List<ExtendUserKey> extendUserKeys = extendUserKeyMapper.selectAll();
        return "hello world 1111";
    }

    @RequestMapping("/3")
    @ResponseBody
    public List<ExtendUserKey> index3(){
        List<ExtendUserKey> extendUserKeys = extendUserKeyMapper.selectAll();
        return extendUserKeys;
    }

    @RequestMapping("/2")
    @ResponseBody
    public String index2(){
        int a = 1/0;
        return "hello world 1111";
    }

}
