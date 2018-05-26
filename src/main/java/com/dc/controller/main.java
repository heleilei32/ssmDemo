package com.dc.controller;

import com.springmvc.pojo.Admin;
import com.springmvc.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class main {

    @RequestMapping("/1")
    @ResponseBody
    public String index(){
        return "hello world 1111";
    }

    @RequestMapping("/2")
    @ResponseBody
    public String index2(){
        int a = 1/0;
        return "hello world 1111";
    }

}
