package com.wxf.common.tools;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 日期工具类
 *
 * @author WangMaoSong
 * @date 2022/8/31 14:06
 */
public class DateToolKit {

    /**
     * 获取当前日期
     *
     * @return 当前日期
     */
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }


    /**
     * 获取当前日期时间
     *
     * @return 当前日期时间
     */
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    /**
     * 是否闰年
     *
     * @param date 日期
     * @return 是否闰年
     */
    public static boolean isLeapYear(LocalDate date) {
        return date.isLeapYear();
    }

    /**
     * 是否大于
     *
     * @param date1 d1
     * @param date2 d1
     * @return 是否大于
     */
    public static boolean isBefore(LocalDate date1, LocalDate date2) {
        return date1.isBefore(date2);
    }

    /**
     * 是否小于
     *
     * @param date1 d1
     * @param date2 d1
     * @return 是否小于
     */
    public static boolean isAfter(LocalDate date1, LocalDate date2) {
        return date1.isAfter(date2);
    }

    /**
     * 格式化日期
     * 20220831转成2022-08-31
     *
     * @param dt 日期
     * @return 格式化后的日期
     */
    public static LocalDate formatDate(String dt) {
        return LocalDate.parse(dt, DateTimeFormatter.BASIC_ISO_DATE);
    }

    /**
     * 格式化日期
     *
     * @param dt        日期
     * @param formatter 格式
     * @return 格式化后的日期
     */
    public static LocalDate formatDate(String dt, DateTimeFormatter formatter) {
        return LocalDate.parse(dt, formatter);
    }

    /**
     * LocalDateTime转时间戳
     *
     * @param localDateTime localDateTime
     * @return 时间戳
     */
    public static long formatLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 格式化localDate
     *
     * @param localDate localDate
     * @param pattern   格式
     * @return 格式化化后的数据
     */
    public static String parseLocalDate(LocalDate localDate, String pattern) {
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 格式化localDate
     *
     * @param localDateTime localDate
     * @param pattern       格式
     * @return 格式化化后的数据
     */

    public static String parseLocalDateTime(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取时间范围内日期字符串
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 时间范围内日期字符串
     */
    public static List<String> getDateStrBetweenTwoLocalDate(LocalDate startTime, LocalDate endTime) {
        List<String> list = new ArrayList<>(16);
        if (startTime.isEqual(endTime)) {
            return Collections.singletonList(parseLocalDate(startTime, "yyyyMMdd"));
        }

        list.add(parseLocalDate(startTime, "yyyyMMdd"));
        while (startTime.isBefore(endTime)) {
            startTime = startTime.plusDays(1);
            String date = parseLocalDate(startTime, "yyyyMMdd");
            list.add(date);
        }
        return list;
    }

    public static void main(String[] args) throws IllegalAccessException {
//        System.out.println(getCurrentDate());
//        System.out.println(getCurrentDateTime());
//        System.out.println(getCurrentTime());
//        System.out.println(isLeapyear(LocalDate.now()));
//        System.out.println(formatDate("20220831"));
//        System.out.println(formatLocalDateTime(LocalDateTime.now()));
//        System.out.println(parseLocalDate(LocalDate.now(), "yyyyMMdd"));
//        System.out.println(parseLocalDateTime(LocalDateTime.now(), "yyyyMMddHHmmss"));
//        List<String> list = getDateStrBetweenTwoLocalDate(LocalDate.of(2022, 11, 1), LocalDate.now());
//        System.out.println(list);
        System.out.println(DateToolKit.formatLocalDateTime(LocalDateTime.now()) + 24 * 3600 * 1000);


    }


}
