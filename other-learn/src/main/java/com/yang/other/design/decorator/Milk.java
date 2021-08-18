package com.yang.other.design.decorator;

/**
 * @ClassName Milk
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/2 下午8:34.
 */

public class Milk extends Decorator{

    public Milk(Drink obj) {
        super(obj);
        setDescription("Milk");
        setPrice(2.5f);
    }
}
