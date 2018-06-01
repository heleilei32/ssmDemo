package com.dc.entity.sys.dto;

/**
 * 24小时时间间隔类行
 * 
 * @date 2017-11-4 下午5:24:30
 * @author cao_xue_yong
 * 
 */
public class TimeInterval {
	/**
	 * 年
	 */
	private int years;

	/**
	 * 月
	 */
	private int months;

	/**
	 * 天
	 */
	private int days;
	
	/**
	 * 小时
	 */
	private int hours;

	/**
	 * 数量
	 */
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

}
