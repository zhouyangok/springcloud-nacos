package com.springcloud.utils;

import cn.hutool.core.text.StrSpliter;
import cn.hutool.core.util.StrUtil;

import java.util.List;

/**
 * @ClassName StrUtils
 * @Description: 字符串工具类
 * @Author zhouyang
 * @Date 2020/9/23 下午9:51.
 */

public class StrUtils {

    /**
     * 根据参数条件截取字符串
     *
     * @return
     */
    public static String getStringSbuString() {
        String path = "smart.png.PNG";
        //isLastSeparator true从最后一个匹配条件截取，false从最前面条件截取
        String result = StrUtil.subAfter(path, ".", true).toLowerCase();
        System.out.println(result);
        return result;
    }

    /**
     * 将字符串转化为list
     * @return
     */
    public static List<String> splitString() {
        String str = "1,2,3,4,5,6,7";
        List<String> str1 = StrSpliter.split(str, ",", true, true);
        System.out.println(str1);
        return str1;
    }

    /**
     * 将list集合转化为指定字符拼接而成的字符串
     * eg: list[a1,a2,a3]
     * result: a1,a2,a3
     * @param list
     * @return
     */
    public static String listToString(List<String> list){
        if(null!=list&&list.size()>0){
            String result = StrUtil.join(",",list);
            return result;
        }
        return null;
    }

}
