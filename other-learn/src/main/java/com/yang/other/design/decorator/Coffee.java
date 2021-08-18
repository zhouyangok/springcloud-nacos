package com.yang.other.design.decorator;

/**
 * @ClassName Coffee
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/2 下午8:17.
 */

public class Coffee extends Drink
{
    @Override
    public float cost() {
        return super.getPrice();
    }
}
