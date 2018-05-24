package com.tangjs.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 日期 工具类
 * @author tangjunshan
 * @date 2018年5月24日  
 *
 *
 */
public class DateUtils {
	
	/**
	 * 根据当前日期计算出与当前日期间隔时间单位的日期
	 * @param currentDate 当前日期
	 * @param dateUnit   时间单位
	 * @param prev   前滚标志
	 * @param dateUnitType  滚动日期的单位类型
	 * Calendar.DATE;		Calendar.DAY_OF_YEAR;		Calendar.YEAR;  Calendar.MONTH; Calendar.WEDNESDAY;
	 *  DateUtils.rollDateByDateUnit(currentDate,2,true,Calendar.DATE) , 向前2天  ,eg:currentDate-> 20180524 , 结果 20180522
	 * @return 前滚或后滚的日期
	 */
	public static Date rollDateByDateUnit(Date currentDate,int dateUnit,boolean prev,int dateUnitType) {
		Calendar cal=GregorianCalendar.getInstance(Locale.getDefault());
		if(currentDate!=null) {
			cal.setTime(currentDate);
		}
		cal.add(dateUnitType, prev?-dateUnit:dateUnit);
		return new Date(cal.getTime().getTime());
	}
	
	
	
	/**
	 * 日期转换
	 * @param date  日期
	 * @param pattern 转换格式
	 * @return 转换后的日期
	 */
	public static String getDate2String(Date date,String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	/**
	 * 日期转换 yyyyMMdd
	 * @param date
	 * @return
	 */
	public static String getDate2String1(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}
	
	/**
	 * 日期转换 yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String getDate2String2(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	/**
	 * 日期转换 yyyy/MM/dd
	 * @param date
	 * @return
	 */
	public static String getDate2String3(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(date);
	}
	
	/**
	 * 日期转换HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String getDate2String4(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * String 转换成日期 java.util.Date
	 * @param date 日期
	 * @param patten 日期格式
	 * @return 日期
	 */
	public static java.util.Date getString2Date(String date,String patten){
		SimpleDateFormat sdf=new SimpleDateFormat(patten);
		java.util.Date obj=null;
		try {
			obj=sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * String 转换成日期 java.sql.Date
	 * @param date 日期
	 * @param patten 日期格式
	 * @return 日期
	 */
	public static Date getString2Date2(String date,String patten){
		SimpleDateFormat sdf=new SimpleDateFormat(patten);
		java.util.Date obj=null;
		try {
			obj=sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date(obj.getTime());
	}
	/**
	 * 获取当前时间 String 类型，格式  yyyy-MM-dd
	 * @return
	 */
	public static String getCurrentDate() {
		Date currDate=new Date(System.currentTimeMillis());
		return getDate2String(currDate, "yyyy-MM-dd");
	}
}
