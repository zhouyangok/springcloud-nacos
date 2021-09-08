package com.yang.other.leecode;

/**
 * @ClassName ReplaceBlank
 * @Description: 替换空格
 * @Author zhouyang
 * @Date 2021/9/8 下午8:43.
 */

public class ReplaceBlank {

    public static void main(String[] args) {
    String s = "we are mans";
        System.out.println(replace(s));
    }

    public static String replace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        if (s != null) {
            char[] cs = s.toCharArray();
            for (char c : cs) {
                if (c == ' ') {
                    stringBuilder.append("%");
                } else {
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }
}
