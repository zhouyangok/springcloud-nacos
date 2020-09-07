package com.elasticsearch.util;

import cn.hutool.core.comparator.PinyinComparator;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.Calendar;

/**
 * @ClassName Utils
 * @Description: Hutool 工具包测试
 * @Author zhouyang
 * @Date 2020/7/15 下午9:09.
 */

public class HutoolUtils {

    public static void main(String[] args) {
        System.out.println(RandomUtil.randomString(18));
        System.out.println(RandomUtil.randomDay(1, 5));
        System.out.println(RandomUtil.randomStringUpper(10));
        System.out.println(DateUtil.date());
        System.out.println(DateUtil.date(Calendar.getInstance()));
        System.out.println(DateUtil.date(System.currentTimeMillis()));
        System.out.println(DateUtil.now());
        System.out.println(DateUtil.today());
    }
}
