package com.dc.Tools;

/**
 * 常用的通用变量
 * 
 * @date 2017-9-29 上午11:15:59
 * @author cao_xue_yong
 * 
 */
public class StaticParameter {

	/**
	 * 默认的文件目录
	 */
	public static final String DefaultDir = "myres";

	/**
	 * 按天统计
	 */
	public static final int Statistics_Type_Day = 0;
	/**
	 * 按月统计
	 */
	public static final int Statistics_Type_Month = 1;
	/**
	 * 按年统计
	 */
	public static final int Statistics_Type_Year = 2;

	/**
	 * 常用来表达没有的意思
	 */
	public static final int Common_No_Have = -1;

	/**
	 * 退订
	 */
	public static final int Order_Type_Unsubscribe = 5;

	/**
	 * 订购成功
	 */
	public static final int Order_Type_Succeed = 1;

	/**
	 * 订购失败
	 */
	public static final int Order_Type_Fail = 0;

	/**
	 * 所有订购的包括成功和失败
	 */
	public static final int Order_Type_All = 3;

	/**
	 * 常用参数开始时间
	 */
	public static final String BeginTime = "beginTime";
	/**
	 * 常用参数结束时间
	 */
	public static final String EndTime = "endTime";
	/**
	 * 常用参数多少条数
	 */
	public static final String SelectCount = "selectCount";
	/**
	 * 常用参数查询的用户
	 */
	public static final String SelectUser = "selectUser";

	/**
	 * 常用当前页面总数量
	 */
	public static final String AllPagesCount = "allPagesCount";

	/**
	 * 常用当前数据总数量
	 */
	public static final String AllDatasCount = "allDatasCount";

	/**
	 * 常用当前页数
	 */
	public static final String CurrentPageIndex = "currentPageIndex";

}
