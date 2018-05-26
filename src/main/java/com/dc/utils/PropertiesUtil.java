package com.dc.utils;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {


    private static Properties props;

    //Tomcat运行时执行
    //代码块执行顺序：静态代码块>普通代码块>构造代码块
    //构造代码块每次都执行，但是静态代码块只执行一次
    static {
        String fileName = "config.properties";
        props = new Properties();
        try {
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
        } catch (IOException e) {
            // TODO 抓取异常
        }
    }

    //自定义俩个get方法，方便调用工具类读取properties文件的属性
    public static String getProperty(String key){
        String value= props.getProperty(key.trim());
        if (StringUtils.isEmpty(value)){
            return null;
        }
        return value.trim();
    }

    public static String getProperty(String key,String defaultValue){
        String value= props.getProperty(key.trim());
        if (StringUtils.isEmpty(value)){
            value = defaultValue;
        }
        return value.trim();
    }

}