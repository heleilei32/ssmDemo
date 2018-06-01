package com.dc.controller.sys;


import com.alibaba.fastjson.JSONArray;
import com.dc.Tools.StatisticsTableTool;
import com.dc.Tools.TempStatisticsData;
import com.dc.Tools.TimeIntervalToList;
import com.dc.Tools.Tools;
import com.dc.entity.sys.dto.ConsoleDataParam;
import com.dc.entity.sys.dto.TimeInterval;
import com.dc.entity.sys.pojo.SysUserorder;
import com.dc.service.sys.UserAccessPVService;
import com.dc.service.sys.UserAccessUVService;
import com.dc.service.sys.UserOderService;
import com.dc.service.sys.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 控制台模块
 */
@Controller
@RequestMapping("/sys")
public class ConsoleController {

    @Autowired
    UserOderService userOderService;

    @Autowired
    UserAccessPVService userAccessPVService;

    @Autowired
    UserAccessUVService userAccessUVService;

    @Autowired
    StatisticsTableTool statisticsTableTool;

    @Autowired
    UserSerivce userSerivce;

    /**
     * 控制台
     * @return
     */
    @RequestMapping("/consoleDataAction")
    public String consoleDataAction(HttpServletRequest request, Model model){
    //进入参数进行非空判断

        String beginTimeStr = Tools.getStringParam(request, "beginTime", null);
        String endTimeStr = Tools.getStringParam(request, "endTime", null);
        // 查询类型
        String checkTypeStr = Tools.getStringParam(request, "ctype", "10");
        if (!Tools.isVaildList(checkTypeStr, "0", "1", "2", "10")) {
            checkTypeStr = "10";
        }
        if (!Tools.isVaildList(checkTypeStr, "0", "1", "2", "10")) {
            checkTypeStr = "10";
        }

        // ////////////////////
        Date beginTime = null;
        Date endTime = null;
        if (beginTimeStr == null) {
            beginTime = Tools.getCurrentStartingTime();
        } else {
            beginTime = Tools.parseTime(beginTimeStr);
        }
        if (endTimeStr == null) {
            endTime = Tools.getCurrentEndingTime();
        } else {
            endTime = Tools.parseTime(endTimeStr);
        }
        int cType = Tools.getValidInt(checkTypeStr,3);
        // ////////////////////
        Tools.setAttribute(request, "beginTime", beginTime);
        Tools.setAttribute(request, "endTime", endTime);
        Tools.setAttribute(request, "ctype", checkTypeStr);
        if (cType == 10) {
            // 24小时的时段
            // 订购数组
            Tools.setAttribute(request, "orderArray_succeed", listToJSArray(TimeIntervalToList.to24TimeList(//
                    userOderService.select24TimeInterval(beginTime, endTime, SysUserorder.UserOrderType.Order_Type_Succeed))));
            Tools.setAttribute(request, "orderArray_fail", listToJSArray(TimeIntervalToList.to24TimeList(//
                    userOderService.select24TimeInterval(beginTime, endTime, SysUserorder.UserOrderType.Order_Type_Fail))));
            Tools.setAttribute(request, "orderArray_unsubscribe", listToJSArray(TimeIntervalToList.to24TimeList(//
                    userOderService.select24TimeInterval(beginTime, endTime, SysUserorder.UserOrderType.Order_Type_Unsubscribe))));
            Tools.setAttribute(request, "orderArray_all", listToJSArray(TimeIntervalToList.to24TimeList(//
                    userOderService.select24TimeInterval(beginTime, endTime, SysUserorder.UserOrderType.Order_Type_All))));
            // 用户pv数组
            Tools.setAttribute(request, "getUserPV", listToJSArray(TimeIntervalToList.to24TimeList(//
                    userAccessPVService.select24TimeInterval(beginTime, endTime))));
            // 用户uv数组
            Tools.setAttribute(request, "getUserUV", listToJSArray(TimeIntervalToList.to24TimeList(//
                    userAccessUVService.selectUV24TimeInterval(beginTime, endTime))));

        } else if (0 == cType || 1 == cType || 2 == cType) {
            // 年月日
            // //////
            TempStatisticsData tsd = statisticsTableTool.getStatistics(cType, beginTime, endTime);
            if (tsd != null) {
                // 时间段的
                // 订购数组
                Tools.setAttribute(request, "orderArray_succeed", listToJSArray(tsd.orderArraySucceed));
                Tools.setAttribute(request, "orderArray_fail", listToJSArray(tsd.orderArrayFail));
                Tools.setAttribute(request, "orderArray_unsubscribe", listToJSArray(tsd.orderArrayUnsubscribe));
                Tools.setAttribute(request, "orderArray_all", listToJSArray(tsd.orderArrayAll));
                // 用户pv数组
                Tools.setAttribute(request, "getUserPV", listToJSArray(tsd.PV));
                // 用户uv数组
                Tools.setAttribute(request, "getUserUV", listToJSArray(tsd.UV));
            }
        }
        Tools.setAttribute(request, "oldUserData", userSerivce.getOldUserOrderCount(1, beginTime, endTime));
        Tools.setAttribute(request, "NewUserData", userSerivce.getNewUserOrderCount(1, beginTime, endTime));

        return "/sys/ConsoleData";
    }

    /**
     * list集合转换到js的数组上
     *
     * @date 2017-11-4 下午3:48:24
     * @author cao_xue_yong
     * @param list
     * @return
     */
    private String listToJSArray(List<Integer> list) {
        JSONArray jsArray = new JSONArray();
        jsArray.addAll(list);
        return jsArray.toString();
    }

}
