package com.keji.blog.util;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
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
     * 将time 类型转换为Date，年月日为当天
     *
     * @param time
     * @return
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
     * @param time
     * @return
     */
    public static int getHourOfTime(Time time) {
        LocalTime localTime = time.toLocalTime();
        return localTime.getHour();
    }

    /**
     * 获取time中的分钟
     *
     * @param time
     * @return
     */
    public static int getMinuteOfTime(Time time) {
        LocalTime localTime = time.toLocalTime();
        return localTime.getMinute();
    }

    /**
     * 获取time中的秒
     *
     * @param time
     * @return
     */
    public static int getSecondOfTime(Time time) {
        LocalTime localTime = time.toLocalTime();
        return localTime.getSecond();
    }

}
