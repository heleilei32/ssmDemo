package com.dc.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * 统计转换过程中临时使用的数据集合，防止并发问题的
 * 
 * @date 2017-11-5 下午3:42:49
 * @author cao_xue_yong
 * 
 */
public class TempStatisticsData {
	// 订购成功
	public List<Integer> orderArraySucceed = null;
	// 订购失败
	public List<Integer> orderArrayFail = null;
	// 订购退订
	public List<Integer> orderArrayUnsubscribe = null;
	// 订购全部
	public List<Integer> orderArrayAll = null;
	// 用户pv
	public List<Integer> PV = null;
	// 用户uv
	public List<Integer> UV = null;

	// 使用的长度
	private int len = 0;

	/**
	 * 初始化
	 * 
	 * @date 2017-11-5 下午3:47:32
	 * @author cao_xue_yong
	 * @param count
	 */
	public void init(int count) {
		len = count;
		orderArraySucceed = new ArrayList<Integer>(len);
		orderArrayFail = new ArrayList<Integer>(len);
		orderArrayUnsubscribe = new ArrayList<Integer>(len);
		orderArrayAll = new ArrayList<Integer>(len);
		PV = new ArrayList<Integer>(len);
		UV = new ArrayList<Integer>(len);
		init();
	}

	// 全部填写0
	private void init() {
		for (int i = 0; i < len; i++) {
			orderArraySucceed.add(0);
			orderArrayFail.add(0);
			orderArrayUnsubscribe.add(0);
			orderArrayAll.add(0);
			PV.add(0);
			UV.add(0);
		}
	}



}
