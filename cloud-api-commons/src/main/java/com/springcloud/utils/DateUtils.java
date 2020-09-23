package com.springcloud.utils;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description: 日期工具类
 * @Author zhouyang
 * @Date 2020/9/23 下午9:50.
 */

public class DateUtils {

    /**
     * 获取当前日期
     * yyyy-MM-dd
     *
     * @return
     */
    public static String getToday() {
        String today = DateUtil.today();
        return today;
    }

    /**
     * 获取当前日期时间
     * yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getNow() {
        String now = DateUtil.now();
        return now;
    }

    /**
     * 获取昨天日期
     * yyyy-MM-dd
     *
     * @return
     */
    public static String getYesterday() {
        Date date = DateUtil.yesterday();
        String yesterday = DateUtil.format(date, "yyyy-MM-dd");
        return yesterday;
    }

    /**
     * 根据传入参数，获取当前日期前多少天，多少小时等
     *
     * @return
     */
    public static String getBeforeAnyDay() {
        int before = -30;
        String day = DateUtil.formatDate(DateUtil.offsetDay(new Date(), before));
        String hour = DateUtil.formatDateTime(DateUtil.offsetHour(new Date(), before));
        return day;
    }

    /**
     * 获取当前时间前一个星期
     * yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static Date getWeekBefore() {
        Date date = DateUtil.lastWeek();
        return date;
    }

    /**
     * 获取当前时间上一个月
     * yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static Date getMonthBefore() {
        Date date = DateUtil.lastMonth();
        System.out.println(date);
        return date;
    }

    /**
     * 当前月份的起始时间
     * 例如：当前2020-08-21，则起始时间为 2020-08-01 00:00:00
     *
     * @return
     */
    public static Date getBeginOfMonth() {
        Date date = DateUtil.beginOfMonth(new Date());
        System.out.println(date);
        return date;
    }

    /**
     * 当前季度的起始时间
     * 例如：当前2020-08月，则起始时间为 2020-07-01 00:00:00
     *
     * @return
     */
    public static Date getBeginOfQuart() {
        Date date = DateUtil.beginOfQuarter(new Date());
        System.out.println(date);
        return date;
    }

    /**
     * 获取给定时间到当前时间的时间差：小时时间差
     * 可以设置参数其他时间格式
     *
     * @return
     */
    public static String getDifferHour() {
        String date1 = "2020-09-11 12:33:12";
        Date foDate1 = DateUtil.parse(date1, "yyyy-MM-dd HH:mm:ss");
        Date foDate2 = DateUtil.date();
        long date = DateUtil.between(foDate1, foDate2, DateUnit.HOUR);
        return Convert.toStr(date);
    }

    /**
     * 中文日期转为字符串日期
     * yyyy-MM-dd
     *
     * @return
     */
    public static String changeCNToEN() {
        String date = "2020年 08 月 07日";
        if (StrUtil.isNotBlank(date)) {
            try {
                date = StrUtil.cleanBlank(date);
                DateTime s = DateUtil.parse(date);
                String result = DateUtil.format(s, "yyyy-MM-dd");
                return result;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
