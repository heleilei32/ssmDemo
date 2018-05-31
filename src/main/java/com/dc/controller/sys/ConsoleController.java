package com.dc.controller.sys;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsoleController {

    @RequestMapping("/consoleDataAction")
    public String consoleDataAction(){



        return "/sys/ConsoleData";
    }

}
