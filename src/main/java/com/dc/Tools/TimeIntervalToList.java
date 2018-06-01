package com.dc.Tools;

import com.dc.entity.sys.dto.TimeInterval;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间间隔转换到list上
 * 
 * @date 2017-11-4 下午5:27:54
 * @author cao_xue_yong
 * 
 */
public class TimeIntervalToList {
	/**
	 * 转换到24小时上
	 * 
	 * @date 2017-11-5 下午3:28:17
	 * @author cao_xue_yong
	 * @param list
	 * @return
	 */
	public static List<Integer> to24TimeList(List<TimeInterval> list) {
		int len = 24;
		// 先初始化一下
		List<Integer> resultList = new ArrayList<Integer>(len);
		for (int i = 0; i < len; i++) {
			resultList.add(0);
		}
		// 非空判断
		if (list == null) {
			return resultList;
		}
		// /////////////////////////////////////////////////////
		int listLen = list.size();
		int listIndex = 0;
		TimeInterval timeInterval = null;
		// 得到第一个数据
		if (listIndex < listLen) {
			timeInterval = list.get(listIndex);
		}
		// 转换到24小时上
		for (int i = 0; i < len; i++) {
			if (timeInterval != null) {
				// 时间相等
				if (i == timeInterval.getHours()) {
					// 填充数据
					resultList.set(i, timeInterval.getCount());
					// 得到下一个数据
					listIndex++;
					if (listIndex < listLen) {
						timeInterval = list.get(listIndex);
					} else {
						timeInterval = null;
					}
				} else {
					// 填充0
					resultList.set(i, 0);
				}
			} else {
				// 填充0
				resultList.set(i, 0);
			}
		}
		return resultList;
	}

}
