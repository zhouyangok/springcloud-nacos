package com.yang.other.design.bridge;

/**
 * @ClassName RedTypePhone
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/3 下午7:20.
 */

public class RedTypePhone extends PhoneType{

    public RedTypePhone(Brand brand) {
        super(brand);
    }
    public void open(){
        super.open();
        System.out.println("yellow phone open");
    }

    public void call(){
        super.open();
        System.out.println("yellow phone call");
    }
}
