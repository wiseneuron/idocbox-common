/*
 * Copyright [2011] [C.H Li http://code.google.com/p/idocbox-common/]
 * Licensed to the Chunhui Li(C.H Li) under one or more contributor license agreements.  
 * See the NOTICE file distributed with this work for additional information 
 * regarding copyright ownership.
 *
 * C.H Li licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.idocbox.common.lang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * date util help to process date related task.
 * @author C.H Li wiseneuron@gmail.com
 * @since 0.0.1.1
 */
public class DateUtil {
	/**
	 * compute (d2 - d1), unit is second.
	 * 
	 * @param d1
	 *            start date.
	 * @param d2
	 *            end date.
	 * @return (d2 - d1)
	 */
	public static long computeTime(Date d1, Date d2) {
		long t = d2.getTime() - d1.getTime();
		Float ts = (t / 1000F);
		return ts.longValue();
	}
	/**
	 * roll date .
	 * @param theDate date to roll.
	 * @param num     number to roll
	 * @param type    Y:year, M:month, D:day.
	 * @return rolled date.
	 */
	public static Date rollDate(Date theDate, int num, String type) {
		Date d = null;
		Calendar theCal = Calendar.getInstance();
		Calendar theCal2 = Calendar.getInstance();
		theCal.setTime(theDate);
		theCal2.setTime(theDate);
		
		if ("Y".equals(type)) {
			theCal.roll(Calendar.YEAR, num);
		} else if ("M".equals(type)) {
			theCal.roll(Calendar.MONTH, num);
			if (theCal2.after(theCal) && num > 0) {
				theCal.roll(Calendar.YEAR, 1);
			}
			if (theCal.after(theCal2) && num < 0) {
				theCal.roll(Calendar.YEAR, -1);
			}
		} else if ("D".equals(type)) {
			theCal.roll(Calendar.DAY_OF_YEAR, num);
			if (theCal2.after(theCal) && num > 0) {
				theCal.roll(Calendar.YEAR, 1);
			}
			if (theCal.after(theCal2) && num < 0) {
				theCal.roll(Calendar.YEAR, -1);
			}
		}
        d = theCal.getTime();
		return d;
	}
	/**
	 * convert date to time stamp.
	 * @param d
	 * @return
	 */
	public static String stamp(Date d){
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		StringBuffer buf = new StringBuffer();
		buf.append(c.get(Calendar.YEAR));
		String month = String.valueOf(c.get(Calendar.MONTH) + 1); 
		buf.append(StringUtil.fillBefore(month, 2, '0'));
		buf.append(c.get(Calendar.DAY_OF_MONTH));
		String hour = String.valueOf(c.get(Calendar.HOUR_OF_DAY)); 
		buf.append(StringUtil.fillBefore(hour, 2, '0'));
		String min = String.valueOf(c.get(Calendar.MINUTE));
		buf.append(StringUtil.fillBefore(min, 2, '0'));
		String seconds = String.valueOf(c.get(Calendar.SECOND));
		buf.append(StringUtil.fillBefore(seconds, 2, '0'));
		
		return buf.toString();
	}
	
	

	private static SimpleDateFormat LONG_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static SimpleDateFormat MID_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	private static SimpleDateFormat SHORT_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	private static SimpleDateFormat SHORT_CN_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	private static SimpleDateFormat LEFTFALLING_STROKE_FORMAT = new SimpleDateFormat("yyyy/MM/dd, HH:mm:ss");

	/**
	 * 3天的毫秒数
	 */
	public static long THREE_DAY_MILLSEC = 3 * 24 * 3600 * 1000;

	/**
	 * 1天的毫秒数
	 */
	public static long ONE_DAY_MILLSEC = 24 * 3600 * 1000;

	/**
	 * 1小时的毫秒数
	 */
	public static long ONE_HOUR_MILLSEC = 3600 * 1000;

	/**
	 * 3小时的毫秒数
	 */
	public static long THREE_HOURS_MILLSEC = 3 * 3600 * 1000;

	/**
	 * 12小时的毫秒数
	 */
	public static long TWELVE_HOURS_MILLSEC = 12 * 3600 * 1000;

	/**
	 * 返回当前日期完整字符串，格式为: yyyy-MM-dd hh:mm:ss
	 * 
	 * @return
	 */
	public static String getLongCurrentDate() {
		return new String(LONG_FORMAT.format(new Date()));
	}

	/**
	 * 给定日期(Date)，返回格式为: yyyy-MM-dd hh:mm:ss的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getLongDate(Date date) {
		if (null == date)
			return "";
		return new String(LONG_FORMAT.format(date));
	}

	/**
	 * 给定日期(long:ms)，返回格式为: yyyy-MM-dd hh:mm:ss的字符串
	 * 
	 * @param value
	 * @return
	 */
	public static String getLongDate(long value) {
		return new String(LONG_FORMAT.format(new Date(value)));
	}
	
	/**
	 * 给定日期(long:ms)，返回格式为: yyyy-MM-dd hh:mm的字符串
	 * 
	 * @param value
	 * @return
	 */
	public static String getMidFormatDate(long value) {
		return new String(MID_FORMAT.format(new Date(value)));
	}
	/**
	 * 返回当前日期简写字符串，格式为: yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getShortCurrentDate() {
		return new String(SHORT_FORMAT.format(new Date()));
	}
	
	/**
	 * 返回当前日期简写字符串，格式为: yyyy年MM月dd日
	 * 
	 * @return
	 */
	public static String getShortCNCurrentDate() {
		return new String(SHORT_CN_FORMAT.format(new Date()));
	}
	
	/**
	 * 返回当前日期简写字符串，格式为: yyyy年MM月dd日
	 * 
	 * @return
	 */
	public static String getShortCNDate(long time) {
		return new String(SHORT_CN_FORMAT.format(new Date(time)));
	}
	
	

	/**
	 * 给定日期(Date)，返回当前日期简写字符串，格式为: yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String getShortDate(Date date) {
		if (null == date)
			return getShortCurrentDate();
		return new String(SHORT_FORMAT.format(date));
	}

	/**
	 * 给定日期(long:ms)，返回当前日期简写字符串，格式为: yyyy-MM-dd
	 * 
	 * @param value
	 * @return
	 */
	public static String getShortDate(long value) {
		return new String(SHORT_FORMAT.format(new Date(value)));
	}

	/**
	 * 返回当前日期中等复杂程度的字符串，格式为: yyyy-MM-dd hh:mm
	 * 
	 * @return
	 */
	public static String getMidCurrentDate() {
		return new String(MID_FORMAT.format(new Date()));
	}
	
	/**
	 * 返回传入日期中等复杂程度的字符串，格式为: yyyy-MM-dd hh:mm
	 * 
	 * @return
	 */
	public static String getMidDateStr(long time) {
		return new String(MID_FORMAT.format(new Date(time)));
	}

	/**
	 * 给定日期(Date)，返回当前日期中等复杂程度的字符串，格式为: yyyy-MM-dd hh:mm
	 * 
	 * @param date
	 * @return
	 */
	public static String getMidDate(Date date) {
		if (null == date)
			return getMidCurrentDate();
		return new String(MID_FORMAT.format(date));
	}

	/**
	 * 给定日期(long:ms)，返回当前日期中等复杂程度的字符串，格式为: yyyy-MM-dd hh:mm
	 * 
	 * @param value
	 * @return
	 */
	public static String getMidDate(long value) {
		return new String(MID_FORMAT.format(new Date(value)));
	}

	/**
	 * 返回时间长度，简短形式，格式为: *d*h*m
	 * 
	 * @param ms
	 * @return
	 */
	public static String getShortDisplayStrOfTime(long ms) {
		int oneSecond = 1000;
		int oneMinute = oneSecond * 60;
		int oneHour = oneMinute * 60;
		int oneDay = oneHour * 24;
		long day = ms / oneDay;
		long hour = (ms - day * oneDay) / oneHour;
		long minute = (ms - day * oneDay - hour * oneHour) / oneMinute;
		String strDay = day < 10 ? "" + day : "" + day;
		String strHour = hour < 10 ? "" + hour : "" + hour;
		String strMinute = minute < 10 ? "" + minute : "" + minute;
		//http://192.168.0.3:8080/browse/ISM-3036
		if(ms > 0 && minute == 0){
			strMinute = "1";
			minute = 1;
		}
		StringBuffer timeBuffer = new StringBuffer();
		if (day > 0) {
			timeBuffer.append(strDay);
			timeBuffer.append("天");
		}
		if (hour > 0) {
			timeBuffer.append(strHour);
			timeBuffer.append("小时");
		}
		if (minute > 0) {
			timeBuffer.append(strMinute);
			timeBuffer.append("分钟");
		}
		return timeBuffer.toString();
	}

	/**
	 * // 将毫秒数换算成x天x时x分x秒x毫秒
	 * 
	 * @param ms
	 * @return
	 */
	public static String getWellTimeFromMilliSecond(long ms) {
		int oneSecond = 1000;
		int oneMinute = oneSecond * 60;
		int oneHour = oneMinute * 60;
		int oneDay = oneHour * 24;
		long day = ms / oneDay;
		long hour = (ms - day * oneDay) / oneHour;
		long minute = (ms - day * oneDay - hour * oneHour) / oneMinute;
		long second = (ms - day * oneDay - hour * oneHour - minute * oneMinute) / oneSecond;
		long milliSecond = ms - day * oneDay - hour * oneHour - minute * oneMinute - second * oneSecond;
		String strDay = day < 10 ? "" + day : "" + day;
		String strHour = hour < 10 ? "" + hour : "" + hour;
		String strMinute = minute < 10 ? "" + minute : "" + minute;
		String strSecond = second < 10 ? "" + second : "" + second;
		String strMilliSecond = milliSecond < 10 ? "" + milliSecond : "" + milliSecond;
		strMilliSecond = milliSecond < 100 ? "" + strMilliSecond : "" + strMilliSecond;
		StringBuffer timeBuffer = new StringBuffer();
		timeBuffer.append(strDay);
		timeBuffer.append("天 ");
		timeBuffer.append(strHour);
		timeBuffer.append("小时 ");
		timeBuffer.append(strMinute);
		timeBuffer.append("分钟 ");
		timeBuffer.append(strSecond);
		timeBuffer.append("秒 ");
		timeBuffer.append(strMilliSecond);
		timeBuffer.append("毫秒 ");
		return timeBuffer.toString();
	}
	
	/**
	 * 
	 *把String格式为yyyy-MM-dd HH:mm的日期转化为yyyy-MM-dd HH:mm:ss的日期型
	 *
	 * @param dateStr
	 * @return
	 */
	public static Long getLongDateByMidformat(String dateStr){
		Date d;
		try {
			d =  MID_FORMAT.parse(dateStr);
			return Long.valueOf(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date().getTime();
	}
	
	public static Long getLongDate(String dateStr){
		Date d;
		try {
			d = SHORT_FORMAT.parse(dateStr);
			return Long.valueOf(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date().getTime();
	}
	/**
	 * 把String转化为yyyy-MM-dd HH:mm:ss
	 * @param dateStr
	 * @return
	 */
	public static Long getLongDateFormString(String dateStr){
		Date d;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			d = LONG_FORMAT.parse(dateStr);
			return Long.valueOf(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date().getTime();
	}
	/**
	 * 得到日期所在的周区间，例如将2008-04-09归入2008-04-07_2008-04-13这个周区间
	 * 
	 * @param dateString 时间字符串
	 * @return
	 */
	public static String getWeekFromDate(String dateString) {
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(dateString);
			Date mondy = new Date();
			Date sundy = new Date();
			int day = date.getDay();
			if (day == 0) {
				mondy.setTime(date.getTime() - 1000 * 60 * 60 * 24 * 6);
				sundy.setTime(date.getTime());
			} else {
				mondy.setTime(date.getTime() - 1000 * 60 * 60 * 24 * (day - 1));
				sundy.setTime(date.getTime() + 1000 * 60 * 60 * 24 * (7 - day));
			}
			sb.append(format.format(mondy));
			sb.append("_");
			sb.append(format.format(sundy));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	/**
	 * 获得当前时间是星期几
	 * @param pTime - 可以传空
	 * @return
	 * @throws Exception
	 */
	public static int dayForWeek(String pTime) {
		Calendar c = Calendar.getInstance();
		if(StringUtil.isEmpty(pTime) || StringUtil.isBlank(pTime)){
			c.setTime(new Date());
		}else{
			try {
				c.setTime(SHORT_FORMAT.parse(pTime));
			} catch (ParseException e) {
				e.printStackTrace();
				return 0;
			}
		}
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return dayForWeek;
	}
	
	/**
	 *  
	 * @param ptime
	 * @return
	 */
	public static String getDayofWeek(String ptime){
		int i = dayForWeek(ptime);
		String result = "";
		switch (i) {
		case 1:
			result = "星期一";
			break;
		case 2:
			result = "星期二";
			break;
		case 3:
			result = "星期三";
			break;
		case 4:
			result = "星期四";
			break;
		case 5:
			result = "星期五";
			break;
		case 6:
			result = "星期六";
			break;
		case 7:
			result = "星期日";
			break;
		default:
			break;
		}
		return result;
	}


	/**
	 * // * 根据毫秒数得到秒数，用于在保存当前时间new Date().getTime()的时候保存整点的秒
	 * 
	 * @param ms
	 * @return
	 */
	public static long getSecondsFromMilliSecond(long ms) {
		long seconds = ms / 1000 * 1000;
		return seconds;
	}
	
	
	
	
	/**
	 * add by JONIM.XIA	
	 * @param dateString 日期字符串
	 * @return 日期Long值
	 */
	public static Long convertStringDate2Long(String dateString) {
		Long datel = new Long(0);
		if (StringUtil.isNotEmpty(dateString)) {
			try {
				//SimpleDateFormat.getDateTimeInstance().
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(dateString);
				datel = date.getTime();
			} catch (Exception exp) {
			}
		}
		return datel;
	}
	
	/**
	 * add by JONIM.XIA	
	 * 日期长整型转换成字符型
	 * @param dateLong
	 * @return
	 */
	public static String convertLong2String(Long dateLong){
		String date = null;
		if(dateLong!=null){
			try {
				Date dt = new Date();
				dt.setTime(dateLong);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				date = sdf.format(dt);
			} catch (Exception exp) {
			}
		}
		return date;
	}
	
	/**
	 * add by JONIM.XIA	
	 * 日期长整型转换成字符型
	 * @param dateLong
	 * @return
	 */
	public static String convertLong2String(Long dateLong,String forMateType){
		String date = null;
		if(dateLong!=null){
			try {
				Date dt = new Date();
				dt.setTime(dateLong);
				if(forMateType==null)forMateType = "yyyy-MM-dd HH:mm";
				SimpleDateFormat sdf = new SimpleDateFormat(forMateType);
				date = sdf.format(dt);
			} catch (Exception exp) {
			}
		}
		return date;
	}
	
	/**
	 * add by JONIM.XIA	
	 * @param dateString 日期字符串
	 * @return 日期Long值
	 */
	public static Long convertStringDate2Long(String dateString,String forMateType) {
		Long datel = new Long(0);
		if (StringUtil.isNotEmpty(dateString)) {
			try {
				if(StringUtil.trim2null(forMateType)==null)forMateType="yyyy-MM-dd HH:mm:ss";
				SimpleDateFormat sdf = new SimpleDateFormat(forMateType);
				Date date = sdf.parse(dateString);
				datel = date.getTime();
			} catch (Exception exp) {
			}
		}
		return datel;
	}
	
	 /**
     * 最近一天开始时间
     * 今天是2010-12-29，则开始时间是2010-12-29 00:00:00 结束是 2010-12-29 23:59:59
     */
    public static Date getTodayStartTime() {
        Calendar cal = Calendar.getInstance();
        changeStartTime(cal);
        return cal.getTime();
    }

    /**
     * 最近一天结束时间
     * 今天是2010-12-29，则开始时间是2010-12-29 00:00:00 结束是 2010-12-29 23:59:59
     */
    public static Date getTodayEndTime() {
        Calendar cal = Calendar.getInstance();
        changeEndTime(cal);
        return cal.getTime();
    }

    /**
     * 本周开始时间
     * 今天是2010-12-29，则本周开始时间是2010-12-27 00:00:00 结束是 2010-12-29 23:59:59
     */
    public static Date getThisWeekStartTime() {
        Calendar cal = Calendar.getInstance();
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 2;
        cal.add(Calendar.DATE, -day_of_week);
        changeStartTime(cal);
        return cal.getTime();
    }

    /**
     * 本周结束时间
     * 今天是2010-12-29，则本周开始时间是2010-12-27 00:00:00 结束是 2010-12-29 23:59:59
     */
    public static Date getThisWeekEndTime() {
        Calendar cal = Calendar.getInstance();
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 2;
        cal.add(Calendar.DATE, -day_of_week);
        cal.add(Calendar.DATE, 6);
        changeEndTime(cal);
        return cal.getTime();
    }

    /**
     * 本月开始时间
     * 今天是2010-12-29，则本月开始时间是2010-12-01 00:00:00 结束是 2010-12-31 23:59:59
     */
    public static Date getThisMonthStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        changeStartTime(cal);
        return cal.getTime();
    }

    /**
     * 本月结束时间
     * 今天是2010-12-29，则本月开始时间是2010-12-01 00:00:00 结束是 2010-12-31 23:59:59
     */
    public static Date getThisMonthEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        changeEndTime(cal);
        return cal.getTime();
    }

    /**
     * 最近三个月的开始时间
     * 今天是2010-12-29，则最近三个月开始时间是2010-10-01 00:00:00 结束是当月月底 2010-12-31 23:59:59
     */
    public static Date getThisThreeMonthStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -2);    //月份减2
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        changeStartTime(cal);
        return cal.getTime();
    }

    /**
     * 最近一年的开始时间
     * 今天是2010-12-29，则最近一年开始时间是2010-01-01 00:00:00 结束是 2010-12-31 23:59:59
     */
    public static Date getThisYearStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.getActualMinimum(Calendar.MONTH));
        cal.set(Calendar.DAY_OF_YEAR, cal.getActualMinimum(Calendar.DAY_OF_YEAR));
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        changeStartTime(cal);
        return cal.getTime();
    }

    /**
     * 最近一年的结束时间
     * 今天是2010-12-29，则最近一年开始时间是2010-01-01 00:00:00 结束是 2010-12-31 23:59:59
     */
    public static Date getThisYearEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.getActualMaximum(Calendar.MONTH));
        cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        changeEndTime(cal);
        return cal.getTime();
    }

    /**
     * 将日历时间设置为yyyy-MM-dd 00:00:00
     */
    public static void changeStartTime(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
    }

    /**
     * 将日历时间设置为yyyy-MM-dd 23:59:59
     */
    public static Calendar changeEndTime(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal;
    }
    
    /**
     * 截断传入时间yyyy-MM-dd HH:mm:ss后面自动生成的毫秒数
     * @param date 传入日期
     * @return 截断毫秒数后返回long型日期
     */
    public static long truncateMillisecond(Date date){
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 String dateStr=sdf.format(date);
    	 Date finalDate=null;
    	 try {
			finalDate=sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return finalDate.getTime();
    }
    /**
     * 获取当前时间实例修改其小时,分钟和毫秒数
     * @param timeStr 小时和分钟字符串 08:00或8:10
     * @return 修改过小时和分钟后的时间
     */
    public static Calendar getDutyUnitDate(String timeStr){
    	Calendar cal=Calendar.getInstance();
        //时间字符串不合法近回输入日期
        if (timeStr == null || (timeStr != null && timeStr.length() > 5)) {
            return cal;
        }
        String hourStr = timeStr.split(":")[0];
        String minuteStr = timeStr.split(":")[1];
        int hour, minute;
        //转换小时
        if (hourStr.length()>1 && hourStr.startsWith("0")) {
            hour = Integer.valueOf(hourStr.substring(1));
        } else {
            hour = Integer.valueOf(hourStr);
        }
        //转换分钟
        if (minuteStr.length()>1 && minuteStr.startsWith("0")) {
        	if(minuteStr.substring(1).equals("0")){
        		minute=0;
        	}else{
        		minute = Integer.valueOf(minuteStr.substring(1));
        	}
        } else {
            minute = Integer.valueOf(minuteStr);
        }
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND,0);
        return cal;
    }
    
    /**
     * 将单位为小时的节点任务时间转为格式为"2011/06/22, 11:05:00"
     * @param monitorService
     */
    public static String convertHours2DatetimeString(long nodeTaskCompleteTime){   
        return LEFTFALLING_STROKE_FORMAT.format(new Date(nodeTaskCompleteTime));
    }
    
	public static void main(String[] args){
		
		System.out.println(DateUtil.class.getClassLoader().getResource("").getPath());
		Long convertStringDate2Long = convertStringDate2Long("2010-03-02 19:09:34", null);
		System.out.println("初始时间: 2010-03-02 19:09:34 "+ convertStringDate2Long);
		
		Long long1 = convertStringDate2Long + 28 * 60 *1000; 
		String convertLong2String = getLongDate(Long.valueOf("1278000000000"));
		System.out.println("加了28分钟后："+convertLong2String);
		
		double random = Math.random();
		long round = Math.round(random * 5);
		System.out.println(Math.round(Math.random() * 2));
		
	  	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date todayStartTime = getTodayStartTime();
        Date todayEndTime = getTodayEndTime();
        System.out.println("最近一天开始时间:" + sdf.format(todayStartTime));
        System.out.println("最近一天结束时间:" + sdf.format(todayEndTime));

        Date currentWeekStartTime = getThisWeekStartTime();
        Date currentWeekEndTime = getThisWeekEndTime();
        System.out.println("本周开始时间:" + sdf.format(currentWeekStartTime));
        System.out.println("本周结束时间:" + sdf.format(currentWeekEndTime));

        Date thisMonthStartTime = getThisMonthStartTime();
        Date thisMonthEndTime = getThisMonthEndTime();
        System.out.println("本月开始时间:" + sdf.format(thisMonthStartTime));
        System.out.println("本月结束时间:" + sdf.format(thisMonthEndTime));

        Date thisThreeMonthStartTime = getThisThreeMonthStartTime();
        System.out.println("最近三个月开始时间:" + sdf.format(thisThreeMonthStartTime));
        System.out.println("最近三个月结束时间:" + sdf.format(thisMonthEndTime));

        Date thisYearStartTime = getThisYearStartTime();
        Date thisYearEndTime = getThisYearEndTime();
        System.out.println("最近一年开始时间:" + sdf.format(thisYearStartTime));
        System.out.println("最近一年结束时间:" + sdf.format(thisYearEndTime));
        
        Calendar dutyDateCal=getDutyUnitDate("08:00");
        System.out.println("值班日历时间+当间时间组合+毫秒清零:"+sdf.format(dutyDateCal.getTime()));
        System.out.println(dutyDateCal.getTime().getTime());
        
        System.out.println(convertHours2DatetimeString(10));
	}
	

}
