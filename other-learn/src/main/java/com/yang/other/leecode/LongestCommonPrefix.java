package com.yang.other.leecode;

import java.util.Arrays;

/**
 * @ClassName LongestCommonPrefix
 * @Description: 最长公共前缀
 * @Author zhouyang
 * @Date 2021/9/15 下午9:01.
 */

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] s = {"reflower","flow","flight"};
        solution(s);
    }

    public static void solution(String[] strs) {
        Arrays.sort(strs);
        String str = strs[0];
        for(String s : strs){
            while (s != str && !s.startsWith(str)){
                str = str.substring(0,str.length()-1);
            }
        }
        System.out.println(str);
    }
}
