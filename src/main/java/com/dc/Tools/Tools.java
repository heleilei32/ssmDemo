package com.dc.Tools;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 常用工具
 * 
 * @author caoxueyong
 * 
 */
public final class Tools {
	private Tools() {

	}

	/** 编码格式,全部都用这个 **/
	public static final String CodingFormat = "UTF-8";
	/** 随机数 **/
	private static final Random random = new Random();

	/**
	 * 格式化时间
	 */
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 时间
	 */
	private static final Date currentDate = new Date(System.currentTimeMillis());

	/**
	 * 分割字符串
	 * 
	 * @param str
	 *            字符串
	 * @param delimiters
	 *            分隔符
	 * @return 返回分割后的字符串
	 * @author caoxueyong
	 */
	public static final String[] split(String str, char delimiters) {
		if (str == null || str.length() <= 0) {
			return null;
		}
		// ///////////////////////////////
		char[] chars = str.toCharArray();

		int len = chars.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (delimiters == chars[i]) {
				count++;
			}
		}
		// ///////////////////////////////
		// 没有返回null
		if (count == 0) {
			return null;
		}
		// 创建返回的字符串组
		String[] result = new String[count + 1];
		int endIndex = 0;
		for (int i = 0; i < result.length; i++) {
			endIndex = str.indexOf(delimiters);
			if (endIndex < 0) {
				result[i] = str;
				return result;
			} else {
				result[i] = str.substring(0, endIndex);
				str = str.substring(endIndex + 1, str.length());
			}
		}
		return null;
	}

	/**
	 * base64编码
	 * 
	 * @date 2017-3-2 下午2:34:00
	 * @author cao_xue_yong
	 * @param code
	 * @return
	 */
	public static final String base64Encode(String code) {
		if (!isValid(code, false)) {
			return null;
		}
		String result = null;
		try {
			byte[] bytes = Base64.encodeBase64(code.getBytes(CodingFormat), true);
			result = new String(bytes, CodingFormat);
		} catch (UnsupportedEncodingException e) {
			result = null;
			DCLog.logException("base64编码异常", e);
		}
		return result.trim();
	}

	/**
	 * base64解码
	 * 
	 * @date 2017-3-2 下午2:59:08
	 * @author cao_xue_yong
	 * @param code
	 * @return
	 */
	public static final String base64Decode(String code) {
		if (code == null || code.length() <= 3) {
			return null;
		}
		String result = null;
		try {
			byte[] bytes = Base64.decodeBase64(code);
			result = new String(bytes, CodingFormat);
		} catch (IOException e) {
			result = null;
			DCLog.logException("base64解码异常", e);
		}
		return result;
	}

	/**
	 * md5 ，加密
	 * 
	 * @date 2017-4-18 下午11:45:44
	 * @author cao_xue_yong
	 * @param data
	 * @return
	 */
	public static final String getMD5String(String data) {
		if (!isValid(data, false)) {
			return null;
		}
		return DigestUtils.md5Hex(data);
	}

	/**
	 * 格式化时间
	 * 
	 * @date 2017-3-3 下午12:57:14
	 * @author cao_xue_yong
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static final String formatDate(Date date) {
		if (date == null) {
			return null;
		}
		synchronized (simpleDateFormat) {
			return simpleDateFormat.format(date);
		}
	}

	/**
	 * 得到当前时间
	 * 
	 * @date 2017-3-3 下午12:50:53
	 * @author cao_xue_yong
	 * @return
	 */
	public static final String getCurrentTime() {
		String result = null;
		synchronized (currentDate) {
			currentDate.setTime(System.currentTimeMillis());
			result = formatDate(currentDate);
		}
		return result;
	}

	/** 差的天数 **/
	public static final int TimeDifference_Day = 1;
	/** 差的月数 **/
	public static final int TimeDifference_Month = 2;
	/** 差的年数 **/
	public static final int TimeDifference_Year = 3;
	/** 差的小时数 **/
	public static final int TimeDifference_Hour = 4;

	/**
	 * 得到2个时间的差值
	 * 
	 * @date 2017-11-4 下午7:15:14
	 * @author cao_xue_yong
	 * @param beginTime
	 * @param endTime
	 * @param timeDifferenceType
	 * @return
	 */
	public static final int getTimeDifferenceValue(Date beginTime, Date endTime, int timeDifferenceType) {
		if (beginTime == null || endTime == null) {
			return -1;
		}
		Date begin = beginTime;
		Date end = endTime;
		// /////////
		int result = -1;
		switch (timeDifferenceType) {
		case TimeDifference_Hour:
			Calendar calHour = Calendar.getInstance();
			calHour.setTime(begin);
			long beginHour = calHour.getTimeInMillis();
			calHour.setTime(end);
			long endHour = calHour.getTimeInMillis();
			result = Integer.parseInt(String.valueOf((endHour - beginHour) / (1000 * 3600)));
			break;
		case TimeDifference_Day:
			Calendar calDay = Calendar.getInstance();
			calDay.setTime(begin);
			long beginDay = calDay.getTimeInMillis();
			calDay.setTime(end);
			long endDay = calDay.getTimeInMillis();
			result = Integer.parseInt(String.valueOf((endDay - beginDay) / (1000 * 3600 * 24)));
			break;
		case TimeDifference_Month:
			Calendar calMonth = Calendar.getInstance();
			calMonth.setTime(begin);
			int beginMonth = calMonth.get(Calendar.MONTH);
			int beginYear = calMonth.get(Calendar.YEAR);
			calMonth.setTime(end);
			int endMonth = calMonth.get(Calendar.MONTH);
			int endYear = calMonth.get(Calendar.YEAR);
			// 差的月份
			int months = endMonth - beginMonth;
			// 差的年份
			int years = (endYear - beginYear) * 12;
			result = months + years;
			break;
		case TimeDifference_Year:
			Calendar calYear = Calendar.getInstance();
			calYear.setTime(begin);
			int beginYear1 = calYear.get(Calendar.YEAR);
			calYear.setTime(end);
			int endYear1 = calYear.get(Calendar.YEAR);
			// 差的年份
			result = endYear1 - beginYear1;
			break;
		}
		return result;
	}

	/**
	 * 是否是当前的时间
	 * 
	 * @date 2017-11-5 下午4:37:55
	 * @author cao_xue_yong
	 * @param beginTime
	 * @param endTime
	 * @param timeDifferenceType
	 * @return
	 */
	public static final boolean getIsCurTime(Date beginTime, Date endTime, int timeDifferenceType) {
		if (beginTime == null || endTime == null) {
			return false;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(beginTime);
		int beginYear = calendar.get(Calendar.YEAR);
		int beginMonth = calendar.get(Calendar.MONTH);
		int beginDays = calendar.get(Calendar.DAY_OF_MONTH);
		int beginHours = calendar.get(Calendar.HOUR_OF_DAY);
		// ////////////
		calendar.setTime(endTime);
		int endYear = calendar.get(Calendar.YEAR);
		int endMonth = calendar.get(Calendar.MONTH);
		int endDays = calendar.get(Calendar.DAY_OF_MONTH);
		int endHours = calendar.get(Calendar.HOUR_OF_DAY);
		// 比较的结果
		boolean result = false;
		switch (timeDifferenceType) {
		case TimeDifference_Year:
			result = (beginYear == endYear);
			break;
		case TimeDifference_Month:
			result = (beginYear == endYear && beginMonth == endMonth);
			break;
		case TimeDifference_Day:
			result = (beginYear == endYear && beginMonth == endMonth && beginDays == endDays);
			break;
		case TimeDifference_Hour:
			result = (beginYear == endYear && beginMonth == endMonth && beginDays == endDays && beginHours == endHours);
			break;
		}
		return result;
	}

	/**
	 * 得到当前的时间
	 * 
	 * @date 2017-3-17 下午2:35:55
	 * @author cao_xue_yong
	 * @return
	 */
	public static final Date getCurrentDate() {
		Date date = new Date(System.currentTimeMillis());
		return date;
	}

	/**
	 * 解析时间
	 * 
	 * @date 2017-3-3 下午12:55:48
	 * @author cao_xue_yong
	 * @param time
	 * @return
	 */
	public static final Date parseTime(String time) {
		if (!isValid(time, false)) {
			return null;
		}
		Date date = null;
		synchronized (simpleDateFormat) {
			try {
				date = simpleDateFormat.parse(time);
			} catch (ParseException e) {
				date = null;
				DCLog.logException("格式化时间异常", e);
			}
		}
		return date;
	}

	/**
	 * 得到一个随机数组 begin <= x < end;
	 * 
	 * @date 2017-3-3 下午3:02:18
	 * @author cao_xue_yong
	 * @param begin
	 * @param end
	 * @return
	 */
	public static final int[] getRandomIntArray(int begin, int end) {
		int len = end - begin;
		if (len <= 1) {
			return null;
		}

		int[] list = new int[len];
		synchronized (random) {
			for (int i = 0; i < len; i++) {
				list[i] = i + begin;
			}
			for (int i = 0; i < len; i++) {
				// //////////////////////
				int index1 = random.nextInt(len);
				int index2 = random.nextInt(len);
				// //////////////////////
				if (index1 == index2) {
					if (index1 == 0) {
						index1 = len - 1;
					} else {
						index1 = 0;
					}
				}
				// 交换下
				int tmp = list[index1];
				list[index1] = list[index2];
				list[index2] = tmp;
			}
		}
		return list;
	}

	/**
	 * 得到一个随机数
	 * 
	 * @date 2017-3-3 下午2:29:35
	 * @author cao_xue_yong
	 * @param range
	 * @return
	 */
	public static final int getRandomInt(int range) {
		int result = 0;
		synchronized (random) {
			result = random.nextInt(range);
		}
		return result;
	}

	/**
	 * 得到一个随机的序列 begin <= x < end;
	 * 
	 * @date 2017-3-3 下午2:29:10
	 * @author cao_xue_yong
	 * @param begin
	 * @param end
	 * @return
	 */
	public static final int getRandomInt(int begin, int end) {
		int len = end - begin;
		if (len < 1) {
			return 0;
		}
		int result = 0;
		synchronized (random) {
			result = random.nextInt(len) + begin;
		}
		return result;
	}

	/**
	 * 得到项目路劲,要自己加"/"
	 * 
	 * @date 2017-3-13 下午2:00:08
	 * @author cao_xue_yong
	 * @param request
	 * @return
	 */
	public static final String getProjectPath(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		String path = "";
		path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		return path;
	}

	/**
	 * 得到string参数
	 * 
	 * @date 2017-3-13 下午4:47:51
	 * @author cao_xue_yong
	 * @param request
	 * @param key
	 *            参数
	 * @param defaultString
	 *            带默认值
	 * @return
	 */
	public static final String getStringParam(HttpServletRequest request, String key, String defaultString) {
		if (request == null) {
			return defaultString;
		}
		String value = request.getParameter(key);
		if (!isValid(value, true)) {
			return defaultString;
		}
		return value;
	}

	/**
	 * 得到string参数，添加一个html的回调
	 * 
	 * @date 2018-1-4 下午2:06:35
	 * @author cao_xue_yong
	 * @param request
	 * @param key
	 * @param defaultString
	 * @param htmlCallback
	 * @return
	 */
	public static final String getStringParam(HttpServletRequest request, String key, String defaultString, boolean htmlCallback) {
		String result = getStringParam(request, key, defaultString);
		if (htmlCallback) {
			setAttribute(request, key, result);
		}
		return result;
	}

	/**
	 * 得到int参数
	 * 
	 * @date 2018-1-2 下午4:24:34
	 * @author cao_xue_yong
	 * @param request
	 * @param key
	 * @param defaultInt
	 * @return
	 */
	public static final int getIntParam(HttpServletRequest request, String key, int defaultInt) {
		if (request == null) {
			return defaultInt;
		}
		String value = request.getParameter(key);
		if (!isValid(value, true)) {
			return defaultInt;
		}
		return Tools.getValidInt(value, 10);
	}

	/**
	 * 得到int参数,添加一个html的回调
	 * 
	 * @date 2018-1-4 下午2:07:38
	 * @author cao_xue_yong
	 * @param request
	 * @param key
	 * @param defaultInt
	 * @param htmlCallback
	 * @return
	 */
	public static final int getIntParam(HttpServletRequest request, String key, int defaultInt, boolean htmlCallback) {
		int result = getIntParam(request, key, defaultInt);
		if (htmlCallback) {
			setAttribute(request, key, result);
		}
		return result;
	}

	/**
	 * 得到 double参数
	 * 
	 * @date 2018-1-4 下午5:20:09
	 * @author cao_xue_yong
	 * @param request
	 * @param key
	 * @param defaultInt
	 * @return
	 */
	public static final double getDoubleParam(HttpServletRequest request, String key, double defaultInt) {
		if (request == null) {
			return defaultInt;
		}
		String value = request.getParameter(key);
		if (!isValid(value, true)) {
			return defaultInt;
		}
		return Tools.getValidDouble(value, 20);
	}

	/**
	 * 得到 double参数,添加一个html的回调
	 * 
	 * @date 2018-1-4 下午5:20:53
	 * @author cao_xue_yong
	 * @param request
	 * @param key
	 * @param defaultInt
	 * @param htmlCallback
	 * @return
	 */
	public static final double getDoubleParam(HttpServletRequest request, String key, double defaultInt, boolean htmlCallback) {
		double result = getDoubleParam(request, key, defaultInt);
		if (htmlCallback) {
			setAttribute(request, key, result);
		}
		return result;
	}

	/**
	 * 得到boolean参数
	 * 
	 * @date 2018-1-2 下午4:26:38
	 * @author cao_xue_yong
	 * @param request
	 * @param key
	 * @param defaultBoolean
	 * @return
	 */
	public static final boolean getBooleanParam(HttpServletRequest request, String key, boolean defaultBoolean) {
		if (request == null) {
			return defaultBoolean;
		}
		String value = request.getParameter(key);
		if (!isValid(value, true)) {
			return defaultBoolean;
		}
		// 如果是true
		if ("true".equalsIgnoreCase(value)) {
			return true;
		}

		return false;
	}

	/**
	 * 得到boolean参数,添加一个html的回调
	 * 
	 * @date 2018-1-4 下午2:08:40
	 * @author cao_xue_yong
	 * @param request
	 * @param key
	 * @param defaultBoolean
	 * @param htmlCallback
	 * @return
	 */
	public static final boolean getBooleanParam(HttpServletRequest request, String key, boolean defaultBoolean, boolean htmlCallback) {
		boolean result = getBooleanParam(request, key, defaultBoolean);
		if (htmlCallback) {
			setAttribute(request, key, result);
		}
		return result;
	}

	/**
	 * 得到Date参数
	 * 
	 * @date 2018-1-5 下午4:48:34
	 * @author cao_xue_yong
	 * @param request
	 * @param key
	 * @param defaultDate
	 * @return
	 */
	public static final Date getDateParam(HttpServletRequest request, String key, Date defaultDate) {
		String time = getStringParam(request, key, null);
		// 当前时间为空，并且有返回时间
		if (time == null && defaultDate != null) {
			return defaultDate;
		}
		Date curTime = parseTime(time);
		return curTime;
	}

	/**
	 * 得到Date参数,添加一个html的回调
	 * 
	 * @date 2018-1-5 下午4:56:55
	 * @author cao_xue_yong
	 * @param request
	 * @param key
	 * @param defaultDate
	 * @param htmlCallback
	 * @return
	 */
	public static final Date getDateParam(HttpServletRequest request, String key, Date defaultDate, boolean htmlCallback) {
		Date result = getDateParam(request, key, defaultDate);
		if (htmlCallback) {
			setAttribute(request, key, result);
		}
		return result;
	}

	/**
	 * 检查字符组合是否符合规范<br>
	 * (0-9,a-z,A-Z和一些支持的特殊字符)<br>
	 * 并且文字里可能包含中文
	 * 
	 * @param str
	 *            要检查的字符串
	 * @param haveChinese
	 *            是否包含了中文
	 * @return
	 */
	public static final boolean isCheckChars(String str, boolean haveChinese) {
		if (!isValid(str, false)) {
			return false;
		}
		char[] ch = str.toCharArray();
		int len = ch.length;
		// 临时比较结果
		boolean tmpResult = false;
		for (int i = 0; i < len; i++) {
			tmpResult = isPermissionChar(ch[i]);
			// 如果不检查中文
			if (!tmpResult && !haveChinese) {
				return false;
			}
			// 检查是否是中文
			if (!tmpResult && haveChinese) {
				if (!isChineseChar(ch[i])) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 是不是全部都是数字
	 * 
	 * @date 2017-10-23 下午2:56:24
	 * @author cao_xue_yong
	 * @param str
	 * @return
	 */
	public static final boolean isNumber(String str) {
		if (!isValid(str, false)) {
			return false;
		}
		int len = str.length();
		int index = 0;
		// 支持负数
		char first = str.charAt(0);
		if ('-' == first) {
			index += 1;
		}
		String str2 = str.substring(index, len);
		if (!isValid(str2, false)) {
			return false;
		}
		len = str2.length();
		char[] numList = str2.toCharArray();
		for (int i = 0; i < len; i++) {
			if (!(numList[i] >= '0' && numList[i] <= '9')) {
				return false;
			}
		}
		return true;
	}

	/** 支持的字符 **/
	private static char[] permissionChar = { '_', '-', '.', '|', '!', '@', '#' };

	/**
	 * 允许的字符串
	 * 
	 * @date 2017-3-6 下午4:39:17
	 * @author cao_xue_yong
	 * @param chars
	 * @return
	 */
	private static final boolean isPermissionChar(char chars) {
		// 数字
		if (chars >= '0' && chars <= '9') {
			return true;
		}
		// 字符
		if (chars >= 'a' && chars <= 'z') {
			return true;
		}
		// 大写字符
		if (chars >= 'A' && chars <= 'Z') {
			return true;
		}
		// 特殊点的字符
		int len = permissionChar.length;
		for (int i = 0; i < len; i++) {
			if (chars == permissionChar[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是不是中文字符
	 * 
	 * @date 2017-4-7 下午4:52:51
	 * @author cao_xue_yong
	 * @param c
	 * @return
	 */
	private static boolean isChineseChar(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS //
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS //
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A//
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B //
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION//
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS //
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			return true;
		}
		return false;
	}

	/**
	 * 是不是纯中文
	 * 
	 * @date 2017-4-7 下午4:53:10
	 * @author cao_xue_yong
	 * @param strName
	 * @return
	 */
	public static final boolean isAllChinese(String str) {
		char[] ch = str.toCharArray();
		int len = ch.length;
		for (int i = 0; i < len; i++) {
			if (!isChineseChar(ch[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 有没有中文
	 * 
	 * @date 2017-4-19 下午4:00:59
	 * @author cao_xue_yong
	 * @param str
	 * @return
	 */
	public static final boolean isHaveChinese(String str) {
		char[] ch = str.toCharArray();
		int len = ch.length;
		for (int i = 0; i < len; i++) {
			if (isChineseChar(ch[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * key是否有效,非空
	 * 
	 * @param key
	 *            ,确保key不是null和""
	 * @param checkDefaultValue
	 * <br>
	 *            比如null,undefined
	 * @return
	 */
	public static final boolean isValid(String key, boolean checkDefaultValue) {
		if (key == null) {
			return false;
		}
		if ("".equals(key)) {
			return false;
		}
		// 检查默认值
		if (checkDefaultValue) {
			if ("null".equalsIgnoreCase(key)) {
				return false;
			}
			if ("undefined".equalsIgnoreCase(key)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查当前值，是否是规定的值
	 * 
	 * @date 2017-10-9 下午4:41:40
	 * @author cao_xue_yong
	 * @param checkValue
	 * @param list
	 * @return
	 */
	public static boolean isVaildList(String checkValue, String... list) {
		// 判断值
		if (!Tools.isValid(checkValue, false)) {
			return false;
		}
		int len = list.length;
		for (int i = 0; i < len; i++) {
			if (list[i].equals(checkValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 得到请求的ip
	 * 
	 * @date 2017-3-13 下午6:22:17
	 * @author cao_xue_yong
	 * @param request
	 * @return
	 */
	public static final String getRequestIP(HttpServletRequest request) {
		if (request == null) {
			return "";
		}
		String ip = request.getRemoteAddr();
		int len = ip.indexOf(":");
		if (len >= 1) {
			ip = "127.0.0.1";
		}
		return ip;
	}

	/**
	 * 得到有效的数字
	 * 
	 * @date 2017-3-17 下午4:32:56
	 * @author cao_xue_yong
	 * @param string
	 * @param limitCount
	 *            限制长度
	 * @return
	 */
	public static final String getValidIntString(String string, int limitCount) {
		if (!Tools.isValid(string, false) || limitCount <= 0) {
			return null;
		}
		int len = string.length();
		int charListLen = len;
		if (len > limitCount) {
			charListLen = limitCount;
		}
		// ////////
		char[] stringList = string.toCharArray();
		// 检查第一位是不是负号
		boolean isHaveNegativeNumber = false;
		if ('-' == stringList[0]) {
			charListLen += 1;
			isHaveNegativeNumber = true;
		}

		char[] list = new char[charListLen];
		int listIndex = 0;
		int i = 0;
		if (isHaveNegativeNumber) {
			listIndex = 1;
			i = 1;
			list[0] = '-';
		}
		// 添加一个如果没有有效值，那么不在创建string对象--->优化下
		boolean haveValidNumber = false;

		for (; i < len; i++) {
			if (stringList[i] >= '0' && stringList[i] <= '9') {
				list[listIndex] = stringList[i];
				listIndex += 1;
				haveValidNumber = true;
				if (listIndex >= charListLen) {
					break;
				}
			}
		}
		if (!haveValidNumber) {
			return null;
		}
		String result = new String(list);
		return result.trim();
	}

	/**
	 * string转换到int上，支持负数
	 * 
	 * @date 2017-5-10 下午5:03:06
	 * @author cao_xue_yong
	 * @param string
	 * @param limitCount
	 * @return
	 */
	public static final int getValidInt(String string, int limitCount) {
		if (!isValid(string, false)) {
			return -1;
		}
		//
		String newNumber = getValidIntString(string, limitCount);
		if (!isValid(newNumber, false)) {
			return -1;
		}
		// 不能超过9位
		if (newNumber.length() > 9) {
			return -1;
		}

		int result = -1;
		try {
			result = Integer.parseInt(String.valueOf(newNumber));
		} catch (Exception e) {
			result = -1;
			DCLog.logException("转换到数字出问题:" + string, e);
		}
		return result;
	}

	/**
	 * 得到有效的double数字
	 * 
	 * @date 2018-1-4 下午5:01:25
	 * @author cao_xue_yong
	 * @param string
	 * @param limitCount
	 * @return
	 */
	public static final String getValidDoubleString(String string, int limitCount) {
		if (!Tools.isValid(string, false) || limitCount <= 0) {
			return null;
		}
		int len = string.length();
		int charListLen = len;
		if (len > limitCount) {
			charListLen = limitCount;
		}
		// ////////
		char[] stringList = string.toCharArray();
		// 检查第一位是不是负号
		boolean isHaveNegativeNumber = false;
		if ('-' == stringList[0]) {
			charListLen += 1;
			isHaveNegativeNumber = true;
		}

		char[] list = new char[charListLen];
		int listIndex = 0;
		int i = 0;
		if (isHaveNegativeNumber) {
			listIndex = 1;
			i = 1;
			list[0] = '-';
		}
		// 添加一个如果没有有效值，那么不在创建string对象--->优化下
		boolean haveValidNumber = false;

		// 是否有小数点
		boolean haveDecimalPoint = false;

		for (; i < len; i++) {
			// //////检查小数点
			if (!haveDecimalPoint) {
				if (stringList[i] == '.') {
					list[listIndex] = stringList[i];
					listIndex += 1;
					haveDecimalPoint = true;
					continue;
				}
			}
			// //////
			if (stringList[i] >= '0' && stringList[i] <= '9') {
				list[listIndex] = stringList[i];
				listIndex += 1;
				haveValidNumber = true;
				if (listIndex >= charListLen) {
					break;
				}
			}
		}
		if (!haveValidNumber) {
			return null;
		}
		// // 没有小数点
		// if (!haveDecimalPoint) {
		// return null;
		// }
		String result = new String(list);
		return result.trim();
	}

	/**
	 * string转换到double上，支持负数
	 * 
	 * @date 2017-5-10 下午5:03:06
	 * @author cao_xue_yong
	 * @param string
	 * @param limitCount
	 * @return
	 */
	public static final double getValidDouble(String string, int limitCount) {
		if (!isValid(string, false)) {
			return 0;
		}
		//
		String newNumber = getValidDoubleString(string, limitCount);
		if (!isValid(newNumber, false)) {
			return 0;
		}
		// // 不能超过9位
		// if (newNumber.length() > 9) {
		// return 0;
		// }
		double result = 0;
		try {
			result = Double.parseDouble(String.valueOf(newNumber));
		} catch (Exception e) {
			result = 0;
			DCLog.logException("转换到数字出问题:" + string, e);
		}
		return result;
	}

	/**
	 * 时间字符串
	 * 
	 * @date 2017-3-17 下午4:42:23
	 * @author cao_xue_yong
	 * @param time
	 * @return
	 */
	public static final boolean isStringTime(String time) {
		// ////////////////////////
		if (!Tools.isValid(time, false)) {
			return false;
		}
		// ////////////////////////

		int type1 = time.indexOf("-");
		if (type1 == 4) {
			// 第一种 2017-03-17 00:00:00
			boolean result = false;
			int type1_1 = time.indexOf(":");
			if (type1_1 == 13) {
				result = time.matches("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}");
			} else {
				result = time.matches("\\d{4}-\\d{1,2}-\\d{1,2}");
			}
			return result;
		}
		return false;
	}

	/**
	 * 得到当前时间几天前
	 * 
	 * @date 2017-3-17 下午5:36:58
	 * @author cao_xue_yong
	 * @param days
	 * @param starting
	 *            当前时间还是0点
	 * @return
	 */
	public static Date getDaysAgo(int days, boolean starting) {
		if (days < 0) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getCurrentDate());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int c_days = calendar.get(Calendar.DAY_OF_MONTH);
		c_days = c_days - days;
		if (starting) {
			calendar.set(year, month, c_days, 0, 0, 0);
		} else {
			calendar.set(year, month, c_days);
		}
		// ////////
		return calendar.getTime();
	}

	/**
	 * 得到几天前
	 * 
	 * @date 2017-11-5 下午5:26:11
	 * @author cao_xue_yong
	 * @param days
	 * @param time
	 * @param starting
	 *            从0开始
	 * @return
	 */
	public static Date getDaysAgo(int days, Date time, boolean starting) {
		if (days < 0) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		day -= days;
		if (starting) {
			calendar.set(year, month, day, 0, 0, 0);
		} else {
			calendar.set(year, month, day);
		}
		// ////////
		return calendar.getTime();
	}

	/**
	 * 得到几个月后
	 * 
	 * @date 2017-11-5 下午5:25:58
	 * @author cao_xue_yong
	 * @param months
	 * @param time
	 * @param starting
	 * @return
	 */
	public static Date getMonthsAgo(int months, Date time, boolean starting) {
		if (months < 0) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		month -= months;
		if (starting) {
			calendar.set(year, month, day, 0, 0, 0);
		} else {
			calendar.set(year, month, day);
		}
		// ////////
		return calendar.getTime();
	}

	/**
	 * 得到几年前
	 * 
	 * @date 2017-11-5 下午5:25:37
	 * @author cao_xue_yong
	 * @param years
	 * @param time
	 * @param starting
	 * @return
	 */
	public static Date getYearsAgo(int years, Date time, boolean starting) {
		if (years < 0) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		year -= years;
		if (starting) {
			calendar.set(year, month, day, 0, 0, 0);
		} else {
			calendar.set(year, month, day);
		}
		// ////////
		return calendar.getTime();
	}

	/**
	 * 得到几天后
	 * 
	 * @date 2017-3-17 下午5:37:37
	 * @author cao_xue_yong
	 * @param days
	 * @param starting
	 *            当前时间还是0点
	 * @return
	 */
	public static Date getDaysLater(int days, boolean starting) {
		if (days < 0) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getCurrentDate());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int c_days = calendar.get(Calendar.DAY_OF_MONTH);
		c_days = c_days + days;
		if (starting) {
			calendar.set(year, month, c_days, 0, 0, 0);
		} else {
			calendar.set(year, month, c_days);
		}
		// ////////
		return calendar.getTime();
	}

	/**
	 * 得到一个指定时间的几天后
	 * 
	 * @date 2017-3-24 下午2:39:34
	 * @author cao_xue_yong
	 * @param days
	 * @param time
	 * @param starting
	 * @return
	 */
	public static Date getDaysLater(int days, Date time, boolean starting) {
		if (days <= 0) {
			return time;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		day += days;
		if (starting) {
			calendar.set(year, month, day, 0, 0, 0);
		} else {
			calendar.set(year, month, day);
		}
		// ////////
		return calendar.getTime();
	}

	/**
	 * 得到几个月后
	 * 
	 * @date 2017-11-5 下午5:02:01
	 * @author cao_xue_yong
	 * @param months
	 * @param time
	 * @param starting
	 * @return
	 */
	public static Date getMonthsLater(int months, Date time, boolean starting) {
		if (months <= 0) {
			return time;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int days = calendar.get(Calendar.DAY_OF_MONTH);
		month += months;
		if (starting) {
			calendar.set(year, month, days, 0, 0, 0);
		} else {
			calendar.set(year, month, days);
		}
		// ////////
		return calendar.getTime();
	}

	/**
	 * 得到几年后
	 * 
	 * @date 2017-11-5 下午5:03:55
	 * @author cao_xue_yong
	 * @param years
	 * @param time
	 * @param starting
	 * @return
	 */
	public static Date getYearsLater(int years, Date time, boolean starting) {
		if (years <= 0) {
			return time;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		year += years;
		if (starting) {
			calendar.set(year, month, day, 0, 0, 0);
		} else {
			calendar.set(year, month, day);
		}
		// ////////
		return calendar.getTime();
	}

	/**
	 * 当前0点
	 * 
	 * @date 2017-3-17 下午5:37:54
	 * @author cao_xue_yong
	 * @return
	 */
	public static Date getCurrentStartingTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getCurrentDate());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int c_days = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, c_days, 0, 0, 0);
		// ////////
		return calendar.getTime();
	}

	/**
	 * 指定结束时间
	 * 
	 * @date 2017-3-17 下午5:38:06
	 * @author cao_xue_yong
	 * @return
	 */
	public static Date getCurrentEndingTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getCurrentDate());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int c_days = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, c_days, 23, 59, 59);
		// ////////
		return calendar.getTime();
	}

	/**
	 * 得到几个小时后的时间
	 * 
	 * @date 2017-9-1 下午4:16:25
	 * @author cao_xue_yong
	 * @param time
	 * @param hours
	 *            间隔小时
	 * @param minute
	 *            间隔分钟
	 * @param seconds
	 *            间隔秒
	 * @return
	 */
	public static Date getHoursLater(Date time, int hours, int minute, int seconds) {
		if (time != null) {
			return time;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int c_days = calendar.get(Calendar.DAY_OF_MONTH);
		int hours_ = calendar.get(Calendar.HOUR_OF_DAY);
		int minute_ = calendar.get(Calendar.MINUTE);
		int seconds_ = calendar.get(Calendar.SECOND);

		calendar.set(year, month, c_days, hours_ + hours, minute_ + minute, seconds_ + seconds);
		// ////////
		return calendar.getTime();
	}

	/**
	 * 指定开始时间
	 * 
	 * @date 2017-3-24 下午2:54:11
	 * @author cao_xue_yong
	 * @param time
	 * @return
	 */
	public static Date getStartingTime(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int c_days = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, c_days, 0, 0, 0);
		// ////////
		return calendar.getTime();
	}

	/**
	 * 指定结束时间
	 * 
	 * @date 2017-3-17 下午5:38:06
	 * @author cao_xue_yong
	 * @return
	 */
	public static Date getEndingTime(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int c_days = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, c_days, 23, 59, 59);
		// ////////
		return calendar.getTime();
	}

	/**
	 * 得到年月日
	 * 
	 * @date 2017-3-22 下午6:04:11
	 * @author cao_xue_yong
	 * @param time
	 * @return
	 */
	public static final String getYYYYMMHH(String time) {
		if (!Tools.isStringTime(time)) {
			return time;
		}
		return time.substring(0, 10);
	}

	/**
	 * 设置cookie
	 * 
	 * @date 2017-3-22 下午8:54:43
	 * @author cao_xue_yong
	 * @param key
	 * @param value
	 * @param response
	 */
	public static void setCookie(String key, String value, HttpServletResponse response) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(key, java.net.URLEncoder.encode(value, CodingFormat));
			cookie.setPath("/");
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			DCLog.logException("设置cookie出问题", e);
		}
	}

	/**
	 * 得到cookie
	 * 
	 * @date 2017-3-22 下午8:55:36
	 * @author cao_xue_yong
	 * @param key
	 * @return
	 */
	public static String getCookie(String key, HttpServletRequest request) {
		Cookie[] cookes = request.getCookies();
		if (null == cookes) {
			return "";
		}
		for (Cookie cookie : cookes) {
			if (cookie.getName().equals(key)) {
				try {
					return java.net.URLEncoder.encode(cookie.getValue(), CodingFormat);
				} catch (UnsupportedEncodingException e) {
					DCLog.logException("得到cookie值", e);
					return "";
				}
			}
		}
		return "";
	}

	/**
	 * 删除cookie
	 * 
	 * @date 2017-3-22 下午8:58:36
	 * @author cao_xue_yong
	 * @param request
	 * @param response
	 * @param key
	 */
	public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String key) {
		if (key == null) {
			return;
		}
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (int j = 0; j < cookies.length; j++) {
				Cookie ce = cookies[j];
				String name = ce.getName();
				if (name != null && name.equals(key)) {
					ce = new Cookie(name, null);
					ce.setPath("/");
					ce.setMaxAge(0);
					response.addCookie(ce);
					return;
				}
			}
		}
	}

	/**
	 * 携带属性
	 * 
	 * @date 2017-8-21 下午4:29:01
	 * @author cao_xue_yong
	 * @param request
	 * @param key
	 * @param value
	 */
	public static void setAttribute(HttpServletRequest request, String key, Object value) {
		if (request == null || !Tools.isValid(key, false) || value == null) {
			return;
		}
		request.setAttribute(key, value);
	}

	/**
	 * request发送json数据
	 * 
	 * @date 2018-1-2 下午3:45:39
	 * @author cao_xue_yong
	 * @param request
	 * @param jsonName
	 * @param jsonData
	 */
	public static void requestSendJson(HttpServletRequest request, String jsonName, String jsonData) {
		setAttribute(request, jsonName, jsonData);
	}

	/**
	 * response发送json数据
	 * 
	 * @date 2018-1-4 下午2:47:08
	 * @author cao_xue_yong
	 * @param response
	 * @param jsonData
	 * @throws IOException
	 */
	public static void responseSendJson(HttpServletResponse response, String jsonData) throws IOException {
		responseSendMsg(response, jsonData);
	}

	/**
	 * 保存key,value到session里
	 * 
	 * @date 2017-4-1 下午5:55:21
	 * @author cao_xue_yong
	 * @param request
	 * @param key
	 * @param value
	 */
	public static void setSessionAttribute(HttpServletRequest request, String key, String value) {
		HttpSession session = request.getSession();
		if (session == null) {
			return;
		}
		session.setAttribute(key, value);
	}

	/**
	 * 根据key得到session里的值
	 * 
	 * @date 2017-4-1 下午5:58:16
	 * @author cao_xue_yong
	 * @param request
	 * @param key
	 * @param defaultValue
	 *            找不到返回的默认值
	 * @return
	 */
	public static String getSessionAttribute(HttpServletRequest request, String key, String defaultValue) {
		HttpSession session = request.getSession();
		if (session == null) {
			return defaultValue;
		}
		Object attribute = session.getAttribute(key);
		if (attribute == null) {
			return defaultValue;
		}
		return attribute.toString();
	}

	/**
	 * 转跳
	 * 
	 * @date 2017-4-7 下午1:12:40
	 * @author cao_xue_yong
	 * @param page
	 * @param request
	 * @param response
	 */
	public static void forward(String page, HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher(page).forward(request, response);
		} catch (ServletException e) {
			DCLog.logException("转跳出问题:" + page, e);
		} catch (IOException e) {
			DCLog.logException("转跳出问题:" + page, e);
		}
	}

	/**
	 * 使用uri重定向
	 * 
	 * @date 2017-4-7 下午5:47:51
	 * @author cao_xue_yong
	 * @param uri
	 * @param request
	 * @param response
	 */
	public static void redirect(String uri, HttpServletRequest request, HttpServletResponse response) {
		String pathUrl = getProjectPath(request) + uri;
		try {
			response.sendRedirect(pathUrl);
		} catch (IOException e) {
			DCLog.logException("重定向有问题:" + pathUrl, e);
		}
	}

	/**
	 * 使用url重定向
	 * 
	 * @date 2017-4-7 下午5:48:30
	 * @author cao_xue_yong
	 * @param url
	 * @param response
	 */
	public static void redirect(String url, HttpServletResponse response) {
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			DCLog.logException("重定向有问题:" + url, e);
		}
	}

	/**
	 * java的数组转换到js数组上
	 * 
	 * @date 2017-5-8 下午2:40:02
	 * @author cao_xue_yong
	 * @param array
	 * @return
	 */
	public static String javaArrayToJSArray(Object[] array) {
		if (array == null || array.length == 0) {
			return "";
		}
		int len = array.length;
		StringBuilder jsArray = new StringBuilder(len * 4);
		for (int i = 0; i < len; i++) {
			jsArray.append("'");
			jsArray.append(array[i]);
			jsArray.append("'");
			if (i < len - 1) {
				jsArray.append(",");
			}
		}
		return jsArray.toString();
	}

	/**
	 * 得到xml的值
	 * 
	 * @date 2017-5-8 下午4:41:37
	 * @author cao_xue_yong
	 * @param xml
	 * @param key
	 * @return
	 */
	public static String getXMLParameter(String xml, String key) {
		if (xml.length() <= 1) {
			return "";
		}
		String head = "<" + key + ">";
		int headIndex = xml.indexOf(head);
		if (headIndex == -1) {
			return "";
		}
		headIndex += head.length();
		// ////
		String end = "</" + key + ">";
		int endIndex = xml.indexOf(end);
		if (endIndex == -1) {
			return "";
		}
		return xml.substring(headIndex, endIndex);
	}

	/**
	 * a/b
	 * 
	 * @date 2017-5-12 下午10:02:59
	 * @author cao_xue_yong
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getAliquot(int a, int b) {
		if (b == 0) {
			return 0;
		}
		int result = a / b;
		if (a % b != 0) {
			result++;
		}
		return result;
	}

	/**
	 * 得到月开始时间
	 * 
	 * @date 2017-5-13 下午1:20:15
	 * @author cao_xue_yong
	 * @return
	 */
	public static final Date getMonthBeginTime(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		calendar.set(year, month, 1, 0, 0, 0);
		// ////////
		return calendar.getTime();
	}

	/**
	 * 得到月最后结束的时间
	 * 
	 * @date 2017-11-5 下午5:47:53
	 * @author cao_xue_yong
	 * @param time
	 * @return
	 */
	public static final Date getMonthEndTime(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, day, 23, 59, 59);
		// ////////
		return calendar.getTime();
	}

	/**
	 * 得到年开始时间
	 * 
	 * @date 2017-5-13 下午1:20:15
	 * @author cao_xue_yong
	 * @return
	 */
	public static final Date getYearBeginTime(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int year = calendar.get(Calendar.YEAR);
		calendar.set(year, 0, 1, 0, 0, 0);
		// ////////
		return calendar.getTime();
	}

	/**
	 * 得到年结束时间
	 * 
	 * @date 2017-11-5 下午5:48:27
	 * @author cao_xue_yong
	 * @param time
	 * @return
	 */
	public static final Date getYearEndTime(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		int year = calendar.get(Calendar.YEAR);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(year, 11, day, 23, 59, 59);
		// ////////
		return calendar.getTime();
	}

	/**
	 * 得到后缀
	 * 
	 * @date 2017-10-11 上午10:58:16
	 * @author cao_xue_yong
	 * @param text
	 * @param split
	 * @return
	 */
	public static final String getSuffix(String text, String split) {
		if (!isValid(text, false)) {
			return null;
		}
		if (!isValid(split, false)) {
			return null;
		}
		int index = text.lastIndexOf(split);
		int len = text.length();
		if (index <= -1 || index >= len) {
			return null;
		}
		return text.substring(index + 1, len);
	}

	/**
	 * 得到前缀
	 * 
	 * @date 2017-10-11 上午10:59:44
	 * @author cao_xue_yong
	 * @param text
	 * @param split
	 * @return
	 */
	public static final String getPrefix(String text, String split) {
		if (!isValid(text, false)) {
			return null;
		}
		if (!isValid(split, false)) {
			return null;
		}
		int index = text.indexOf(split);
		if (index <= -1) {
			return null;
		}
		return text.substring(0, index);

	}

	/**
	 * 得到unicode码
	 * 
	 * @date 2017-11-27 下午4:05:17
	 * @author cao_xue_yong
	 * @param msg
	 *            支付窜
	 * @param upperCase
	 *            是否要大写
	 * @return
	 */
	public static final String getUnicode(String msg, boolean upperCase) {
		if (!isValid(msg, false)) {
			return null;
		}
		// ////////////
		char[] charArray = msg.toCharArray();
		int len = charArray.length;
		StringBuilder buff = new StringBuilder(len * 2);
		for (int i = 0; i < len; i++) {
			String hexB = Integer.toHexString(charArray[i]);
			buff.append("\\u");
			if (hexB.length() <= 2) {
				buff.append("00");
			}
			buff.append(hexB);
		}
		// 转换到大写上
		if (upperCase) {
			return buff.toString().toUpperCase();
		}
		return buff.toString();
	}

	/**
	 * 得到沃橙特殊使用的编码
	 * 
	 * @date 2017-11-27 下午4:38:14
	 * @author cao_xue_yong
	 * @param msg
	 * @return
	 */
	public static final String getUnicode_WoCheng(String msg) {
		if (!isValid(msg, false)) {
			return null;
		}
		// ////////////
		char[] charArray = msg.toCharArray();
		int len = charArray.length;
		StringBuilder buff = new StringBuilder(len * 2);
		for (int i = 0; i < len; i++) {
			String hexB = Integer.toHexString(charArray[i]);
			buff.append("&#x");
			if (hexB.length() <= 2) {
				buff.append("00");
			}
			buff.append(hexB);
			buff.append(";");
		}
		return buff.toString();
	}

	/**
	 * 解析 unicode编码
	 * 
	 * @date 2017-11-27 下午4:09:41
	 * @author cao_xue_yong
	 * @param unicodeMsg
	 * @return
	 */
	public static final String parseUnicode(String unicodeMsg) {
		if (!isValid(unicodeMsg, false)) {
			return null;
		}
		unicodeMsg = unicodeMsg.toLowerCase();
		// //
		int startIndex = 0;
		int endIndex = 0;
		// //
		startIndex = unicodeMsg.indexOf("\\u");
		StringBuilder buff = null;
		if (startIndex >= 0) {
			buff = new StringBuilder();
		}
		// ///
		while (startIndex > -1) {
			String tmpChar = null;
			endIndex = unicodeMsg.indexOf("\\u", startIndex + 2);
			if (endIndex == -1) {
				tmpChar = unicodeMsg.substring(startIndex + 2, unicodeMsg.length());
			} else {
				tmpChar = unicodeMsg.substring(startIndex + 2, endIndex);
			}
			char curChar = (char) Integer.parseInt(tmpChar, 16);
			buff.append(Character.toString(curChar));
			// ////////
			startIndex = endIndex;
		}
		// ////////
		if (buff == null) {
			return null;
		}
		return buff.toString();
	}

	/**
	 * response发送信息
	 * 
	 * @date 2018-1-2 下午2:24:27
	 * @author cao_xue_yong
	 * @param response
	 * @param msg
	 * @throws IOException
	 */
	public static final void responseSendMsg(HttpServletResponse response, String msg) throws IOException {
		if (response == null) {
			return;
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		if (printWriter == null) {
			return;
		}
		printWriter.print(msg);
		printWriter.flush();
		printWriter.close();
	}

	/**
	 * 设置请求编码格式
	 * 
	 * @date 2018-1-4 下午5:52:20
	 * @author cao_xue_yong
	 * @param request
	 * @throws UnsupportedEncodingException
	 */
	public static final void setRequestEncoding(HttpServletRequest request) throws UnsupportedEncodingException {
		if (request == null) {
			return;
		}
		request.setCharacterEncoding(CodingFormat);
	}

	// ////////////////////////////////////////////////////////////////////////////////////
	// http
	/**
	 * 发送http，用post,这个在关闭的时候有问题，要重新进行优化
	 * 
	 */
	public static final String httpPost(String sendUrl, String data) {
		// String result = "";
		// try {
		// URL url = new URL(sendUrl);
		// // ////////////
		// HttpURLConnection httpURLConnection = (HttpURLConnection)
		// url.openConnection();
		// // 设置通用的请求属性
		// httpURLConnection.setRequestProperty("accept", "*/*");
		// httpURLConnection.setRequestProperty("connection", "Keep-Alive");
		//
		// // httpURLConnection.setRequestProperty("Content-Type",
		// // "application/json");
		//
		// httpURLConnection.setRequestProperty("Charset", "UTF-8");
		// httpURLConnection.setRequestMethod("POST");
		// httpURLConnection.setDoOutput(true); // 需要输出
		// httpURLConnection.setDoInput(true); // 需要输入
		// httpURLConnection.setUseCaches(false); // 不允许缓存
		// // 连接和读取时间
		// httpURLConnection.setConnectTimeout(1000 * 5);
		// httpURLConnection.setReadTimeout(1000 * 5);
		// // 建立输入流，向指向的URL传入参数
		// DataOutputStream dos = new
		// DataOutputStream(httpURLConnection.getOutputStream());
		// dos.writeBytes(data);
		// dos.flush();
		// dos.close();
		// // //////////////////////////////////
		// int resultCode = httpURLConnection.getResponseCode();
		// // /////////////////
		// if (200 == resultCode) {
		// InputStream input = httpURLConnection.getInputStream();
		// InputStreamReader inputReader = new InputStreamReader(input);
		// // ///////////
		// // 定义 BufferedReader输入流来读取URL的响应
		// BufferedReader in = new BufferedReader(inputReader);
		// StringBuffer stringBuffer = new StringBuffer();
		// String line = "";
		// while ((line = in.readLine()) != null) {
		// stringBuffer.append(line);
		// }
		// result = stringBuffer.toString();
		// } else {
		// result = "";
		// DCLog.log("httpPost返回有问题", "ResponseCode:" + resultCode);
		// }
		// } catch (Exception e) {
		// result = "";
		// DCLog.logException("发送httpPost有问题:", e);
		// }
		// return result;
		return null;
	}
}
