package com.dc.controller.sys;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制台模块
 */
@Controller
@RequestMapping("/sys")
public class ConsoleController {

    /**
     * 控制台
     * @return
     */
    @RequestMapping("/consoleDataAction")
    public String consoleDataAction(){



        return "/sys/ConsoleData";
    }

}
