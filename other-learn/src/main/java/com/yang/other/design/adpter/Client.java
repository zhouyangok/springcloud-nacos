package com.yang.other.design.adpter;

/**
 * @ClassName Client
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/7/27 下午7:28.
 */

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
