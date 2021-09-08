package com.yang.other.datastructure;

/**
 * @ClassName Test
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/31 下午9:33.
 */

public class Test {
    public static void main(String[] args) {
        int c = 3;
        int a = c;
        int b = c;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }
}
