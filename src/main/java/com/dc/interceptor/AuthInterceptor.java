package com.dc.interceptor;

import com.dc.entity.sys.pojo.SysAdmin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse HttpServletResponse, Object o) throws Exception {
        SysAdmin curAdmin = (SysAdmin) httpServletRequest.getSession().getAttribute(SysAdmin.SysAdminStatus.SESSION_LOGINUSER);
        if (curAdmin==null){
            httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest,HttpServletResponse);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
