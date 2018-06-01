package com.dc.Tools;


import com.dc.entity.sys.pojo.SysStatistics;
import com.dc.service.sys.SysStatisticsService;
import com.dc.service.sys.UserAccessPVService;
import com.dc.service.sys.UserOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 统计表的转换工具
 * 
 * @date 2017-11-5 下午3:40:06
 * @author cao_xue_yong
 * 
 */
@Service
public class StatisticsTableTool {


	@Autowired
	SysStatisticsService sysStatisticsService;


	@Autowired
	UserOderService userOderService;

	@Autowired
	UserAccessPVService userAccessPVService;


	/**
	 * 得到统计
	 * 
	 * @date 2017-11-5 下午3:51:13
	 * @author cao_xue_yong
	 * @param type
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public  TempStatisticsData getStatistics(int type, Date beginTime, Date endTime) {
		// 转换到当前的开始和结束时间上，防止时间有问题
		beginTime = Tools.getStartingTime(beginTime);
		endTime = Tools.getEndingTime(endTime);
		int timeType = 0;
		// 长度
		int arrayLen = 0;
		switch (type) {
		case StaticParameter.Statistics_Type_Day:// 统计天
			arrayLen = Tools.getTimeDifferenceValue(beginTime, endTime, Tools.TimeDifference_Day);
			timeType = Tools.TimeDifference_Day;
			break;
		case StaticParameter.Statistics_Type_Month:// 统计月
			arrayLen = Tools.getTimeDifferenceValue(beginTime, endTime, Tools.TimeDifference_Month);
			timeType = Tools.TimeDifference_Month;
			break;
		case StaticParameter.Statistics_Type_Year:// 统计年
			arrayLen = Tools.getTimeDifferenceValue(beginTime, endTime, Tools.TimeDifference_Year);
			timeType = Tools.TimeDifference_Year;
			break;
		}
		if (arrayLen < 0) {
			return null;
		}
		// 统计的数据
		int statisticsCount = sysStatisticsService.allCount(type, beginTime, endTime);
		List<SysStatistics> list = sysStatisticsService.select(type, beginTime, endTime, 0, statisticsCount + 1);
		// 初始化临时数据
		TempStatisticsData tsd = new TempStatisticsData();
		tsd.init(arrayLen + 1);
		int j = statisticsCount - 1;
		// 得到第一个当前的统计表
		SysStatistics curStatistics = null;
		if (j >= 0) {
			curStatistics = list.get(j);
		}
		// 比较时间
		Date compareTime = beginTime;
		// 时间是否是今天
		boolean isEqual = false;

		// 补充今天的数据
		boolean replenishmentCurDay = false;
		Date curDate = Tools.getCurrentDate();
		boolean isHave = false;
		// 开始赋值
		for (int i = 0; i <= arrayLen; i++) {
			if (!isHave) {
				// 是否要补充今天的数据
				replenishmentCurDay = Tools.getIsCurTime(compareTime, curDate, timeType);
			}
			// 补充今天的数据
			if (!isHave && replenishmentCurDay) {
				isHave = true;
				Date replenishmentBeginDate = Tools.getCurrentStartingTime();
				Date replenishmentendDate = Tools.getCurrentEndingTime();
				// 填充数据
				int succeedCount = userOderService.allCount(null, StaticParameter.Order_Type_Succeed, replenishmentBeginDate, replenishmentendDate, null);
				tsd.orderArraySucceed.set(i, tsd.orderArraySucceed.get(i) + succeedCount);
				//
				int failCount = userOderService.allCount(null, StaticParameter.Order_Type_Fail, replenishmentBeginDate, replenishmentendDate, null);
				tsd.orderArrayFail.set(i, tsd.orderArrayFail.get(i) + failCount);
				//
				int UnsubscribeCount = userOderService.allCount(null, StaticParameter.Order_Type_Unsubscribe, replenishmentBeginDate, replenishmentendDate, null);
				tsd.orderArrayUnsubscribe.set(i, tsd.orderArrayUnsubscribe.get(i) + UnsubscribeCount);
				//
				tsd.orderArrayAll.set(i, tsd.orderArrayAll.get(i) + (succeedCount + failCount + UnsubscribeCount));
				//
				int pvCount = userAccessPVService.allCount(null, null, null, replenishmentBeginDate, replenishmentendDate);
				tsd.PV.set(i, tsd.PV.get(i) + pvCount);
				//
				int uvCount = userAccessPVService.accordingToPVGetsUV(replenishmentBeginDate, replenishmentendDate);
				tsd.UV.set(i, tsd.UV.get(i) + uvCount);
			}
			// 添加统计表数据
			if (curStatistics != null) {
				// 时间是否是今天
				isEqual = Tools.getIsCurTime(compareTime, curStatistics.getTime(), timeType);
				// 就是今天
				if (isEqual) {
					// 得到退订数据
					int fail = curStatistics.getSendOrderCount() - curStatistics.getOrderSucceedCount() - curStatistics.getUnsubscribeCount();
					if (fail < 0) {
						fail = 0;
					}
					// 填充数据
					tsd.orderArraySucceed.set(i, tsd.orderArraySucceed.get(i) + curStatistics.getOrderSucceedCount());
					tsd.orderArrayFail.set(i, tsd.orderArrayFail.get(i) + fail);
					tsd.orderArrayUnsubscribe.set(i, tsd.orderArrayUnsubscribe.get(i) + curStatistics.getUnsubscribeCount());
					tsd.orderArrayAll.set(i, tsd.orderArrayAll.get(i) + curStatistics.getSendOrderCount());
					tsd.PV.set(i, tsd.PV.get(i) + curStatistics.getPv());
					tsd.UV.set(i, tsd.UV.get(i) + curStatistics.getUv());
					// //
					j--;
					if (j >= 0) {
						curStatistics = list.get(j);
					} else {
						curStatistics = null;
					}
				} else {
					// 没有的数据填写0
					// 填充数据
					tsd.orderArraySucceed.set(i, tsd.orderArraySucceed.get(i) + 0);
					tsd.orderArrayFail.set(i, tsd.orderArrayFail.get(i) + 0);
					tsd.orderArrayUnsubscribe.set(i, tsd.orderArrayUnsubscribe.get(i) + 0);
					tsd.orderArrayAll.set(i, tsd.orderArrayAll.get(i) + 0);
					tsd.PV.set(i, tsd.PV.get(i) + 0);
					tsd.UV.set(i, tsd.UV.get(i) + 0);
				}
			} else {
				// 没有的数据填写0
				// 填充数据
				tsd.orderArraySucceed.set(i, tsd.orderArraySucceed.get(i) + 0);
				tsd.orderArrayFail.set(i, tsd.orderArrayFail.get(i) + 0);
				tsd.orderArrayUnsubscribe.set(i, tsd.orderArrayUnsubscribe.get(i) + 0);
				tsd.orderArrayAll.set(i, tsd.orderArrayAll.get(i) + 0);
				tsd.PV.set(i, tsd.PV.get(i) + 0);
				tsd.UV.set(i, tsd.UV.get(i) + 0);
			}
			// 循环下一个时间
			if (Tools.TimeDifference_Day == timeType) {
				// 得到一天前
				compareTime = Tools.getDaysLater(1, compareTime, false);
			} else if (Tools.TimeDifference_Month == timeType) {
				// 得到一月前
				compareTime = Tools.getMonthsLater(1, compareTime, false);
			} else if (Tools.TimeDifference_Year == timeType) {
				// 得到一年前
				compareTime = Tools.getYearsLater(1, compareTime, false);
			}
		}
		return tsd;
	}
}
