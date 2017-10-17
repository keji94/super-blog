package com.keji.blog.java8.date;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoField;

/**
 * @author: wb-ny291824
 * @description java8时间api demo
 * @date: Created in 2017/10/12
 * @modified: By:
 */
public class DateDemo {

    /**
     * LocalDate:该类的实例是一个不可变对象，它只提供了简单的日期，并不含当天的时间信息。
     *           另外，它也不附带任何与时区相关的信息。
     */
    @Test
    public void demo1() {
        //获取当前时间
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2017, 10, 12);
        LocalDate parse = LocalDate.parse("2017-10-12");

        //年
        int year = date.getYear();
        //几月(英文)
        Month month = date.getMonth();
        //几号
        int dayOfMonth = date.getDayOfMonth();
        //星期几
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        //一年的第几天
        int dayOfYear = date.getDayOfYear();
        //当前月有多少天
        int length = date.lengthOfMonth();
        //是否是闰年
        boolean leapYear = date.isLeapYear();

        //TemporalField是一个接口，它定义了如何访问temporal对象某个字段的值。 ChronoField枚举实现了这一接口，所以你可以很方便地使用get方法得到枚举元素的值
        int year2 = date.get(ChronoField.YEAR);
        int month2 = date.get(ChronoField.MONTH_OF_YEAR);
        int day2 = date.get(ChronoField.DAY_OF_MONTH);
    }

    /**
     * LocalTime：时间
     */
    @Test
    public void demo2() {
        LocalTime now = LocalTime.now();
        LocalTime time = LocalTime.of(12, 49, 30, 12);
        LocalTime parse = LocalTime.parse("10:26:30");

    }

    /**
     * LocalDateTime:合并日期和时间:同时表示了日期和时间，但不带有时区信息，你可以直接创建，也可以通过合并日期和时间对象构造
     */
    @Test
    public void demo3() {
        LocalDate date = LocalDate.parse("2014-03-18");
        LocalTime time = LocalTime.parse("13:45:20");
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();
    }

    @Test
    public void testAvg() {
        int sum = 4045 + 4045 + 3995 + 3995 + 3988 + 3988 ;
        int count = 6;
        int avg = sum / count;
        System.out.println(avg);
    }

}
