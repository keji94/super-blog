package com.keji.blog.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author wb-ny291824
 * @version $Id: DateUtil.java, v 0.1 2018-01-02 10:51 wb-ny291824 Exp $$
 */
public class DateUtil {

    /**
     * 获取年
     *
     * @return 年
     */
    public static int getYear() {

        LocalTime localTime = LocalTime.now();
        return localTime.get(ChronoField.YEAR);
    }

    /**
     * 获取月份
     *
     * @return 月份
     */
    public static int getMonth() {
        LocalTime localTime = LocalTime.now();
        return localTime.get(ChronoField.MONTH_OF_YEAR);
    }

    /**
     * 获取某月的第几天
     *
     * @return 几号
     */
    public static int getMonthOfDay() {
        LocalTime localTime = LocalTime.now();
        return localTime.get(ChronoField.DAY_OF_MONTH);
    }

    /**
     * 获取当前年月日，格式20180428
     * @return int
     */
    public static int getDate() {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String date = format.format(new Date());
        return Integer.parseInt(date);
    }

    /**
     * 将time 类型转换为Date，年月日为当天
     *
     * @param time time
     * @return date
     */
    public static Date convertTimeToDate(Time time) {
        LocalTime localTime = time.toLocalTime();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate.getYear(), localDate.getMonth(),
                localDate.getDayOfMonth(), localTime.getHour(), localTime.getMinute(), localTime.getSecond());

        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 获取time中的小时
     *
     * @param time time
     * @return hour
     */
    public static int getHourOfTime(Time time) {
        LocalTime localTime = time.toLocalTime();
        return localTime.getHour();
    }

    /**
     * 获取time中的分钟
     *
     * @param time time
     * @return minute
     */
    public static int getMinuteOfTime(Time time) {
        LocalTime localTime = time.toLocalTime();
        return localTime.getMinute();
    }

    /**
     * 获取time中的秒
     *
     * @param time time
     * @return second
     */
    public static int getSecondOfTime(Time time) {
        LocalTime localTime = time.toLocalTime();
        return localTime.getSecond();
    }

    /**
     * @return 返回当天的起始时间
     */
    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * @return 返回当天的结束时间
     */
    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 获得指定日期的后一天
     *
     * @param specifiedDay 指定日期
     * @return 后一天
     */
    public static String getSpecifiedDayAfter(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }

    /**
     * 获得指定日期的前一天
     *
     * @param specifiedDay 指定日期
     * @return 前一天
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(new SimpleDateFormat("yy-MM-dd").parse(specifiedDay));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }

    /**
     * 为Date增加分钟 减传负数
     *
     * @param date        日期
     * @param plusMinutes 要增加的分钟数
     * @return 新的日期
     */
    public static Date addMinutes(Date date, Long plusMinutes) {
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime newDateTime = dateTime.plusMinutes(plusMinutes);
        return Date.from(newDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static void main(String[] args) {
        Date date = addMinutes(new Date(), -30L);
        System.out.println(date);
    }

}
