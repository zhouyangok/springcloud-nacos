package com.yang.other.design.bridge;

/**
 * @ClassName ClientTest
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/3 下午7:22.
 */

public class ClientTest {
    public static void main(String[] args) {
        Brand brand = new Huawei();
        PhoneType phoneType = new RedTypePhone(brand);
        phoneType.open();
        phoneType.call();

    }
}
