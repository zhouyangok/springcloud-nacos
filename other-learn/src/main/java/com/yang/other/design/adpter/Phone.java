package com.yang.other.design.adpter;

/**
 * @ClassName Phone
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/7/27 下午7:26.
 */

public class Phone {


    public void charging(Voltage5V v){
        if(v.output5V() == 5){
            System.out.println("电压为5V,可以充电！");
        }
        System.out.println("无法充电！");

    }
}
