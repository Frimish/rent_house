package com.itany.rent.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期相关工具类
 * @author ldl
 * @date 2018年5月9日 下午2:28:07
 * @version 1.0
 */
public class DateUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat();
	private static String default_pattern = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 把日期对象使用默认的方式转成日期字符串
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date){
		sdf.applyPattern(default_pattern);
		String format = sdf.format(date);
		return format;
	}
	/**
	 * 把日期对象使用给定的方式转成日期字符串
	 * @param date
	 * @param pattern 给定的转换方式
	 * @return 
	 */
	public static String formatDate(Date date, String pattern){
		sdf.applyPattern(pattern);
		String format = sdf.format(date);
		return format;
	}
	/**
	 * 把日期字符串使用默认的方式转成日期对象
	 * @param source
	 * @return
	 */
	public static Date parseDate(String source){
		sdf.applyPattern(default_pattern);
		Date date = null;
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 把日期字符串使用给定的方式转成日期对象
	 * @param source
	 * @param pattern 给定的转换方式
	 * @return
	 */
	public static Date parseDate(String source, String pattern){
		sdf.applyPattern(pattern);
		Date date = null;
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 把java.util.Date转换成java.sql.Date
	 * @param date java.util.Date
	 * @return
	 */
	public static java.sql.Date utilDateToSqlDate(Date date){
		java.sql.Date d = new java.sql.Date(date.getTime());
		return d;
	}
	/**
	 * 把java.sql.Date转换成java.util.Date
	 * @param date java.sql.Date
	 * @return
	 */
	public static Date sqlDateToUtilDate(java.sql.Date date){
		Date d = new Date(date.getTime());
		return d;
	}
	
}
