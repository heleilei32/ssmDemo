package com.dc.controller.sys;

import com.dc.entity.sys.pojo.SysAdmin;
import com.dc.service.sys.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class SystemController {

    @Autowired
    SystemService systemService;



    @RequestMapping("/login")
    public String login(){


        return "/sys/login";
    }


    /**
     * 登录
     * @param cname
     * @param cpasswd
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping("/loginLogicAction")
    public String loginLogicAction(String cname, String cpasswd, Model model, HttpServletRequest request, HttpServletResponse response,HttpSession session){

        SysAdmin sysAdmin = null;
        if (!StringUtils.isEmpty(cname)){
            SysAdmin param = new SysAdmin();
            param.setAdmin(cname);
            sysAdmin = systemService.selectOne(param);
        }


        if (sysAdmin != null && cpasswd.equals(sysAdmin.getPassword())) {
            //单点登录需要用到 sessionId 之前做的有问题
            session.setAttribute(SysAdmin.SysAdminStatus.SESSION_LOGINUSER,sysAdmin);
            model.addAttribute("curAdminName",sysAdmin.getAdmin());
            return "/sys/NavigationBar";

        }else{
            model.addAttribute("showMessage","用户名和密码不对");
            return "forward:/login";
        }
    }


}
