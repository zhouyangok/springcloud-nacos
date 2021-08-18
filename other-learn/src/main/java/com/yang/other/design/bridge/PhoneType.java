package com.yang.other.design.bridge;

/**
 * @ClassName PhoneType
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/3 下午7:18.
 */

public abstract class PhoneType {
    protected Brand brand;

    public PhoneType(Brand brand) {
        this.brand = brand;
    }

    protected void close(){
        brand.close();
    }
    protected void open(){
        brand.open();
    }

    protected void call(){
        brand.call();
    }
}
