package com.dc.entity.sys.dto;

public class ConsoleDataParam {
    private String beginTime;   //null
    private String endTime;     //null
    private String ctype;       //"0", "1", "2", "10" 默认为10

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
}
