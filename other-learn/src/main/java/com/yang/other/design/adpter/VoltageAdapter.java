package com.yang.other.design.adpter;

/**
 * @ClassName VoltageAdapter
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/7/27 下午7:25.
 */

public class VoltageAdapter extends Voltage220V implements Voltage5V{

    @Override
    public int output5V() {
        int src = output220V();
        int dsp = src/44;
        return dsp;
    }
}
