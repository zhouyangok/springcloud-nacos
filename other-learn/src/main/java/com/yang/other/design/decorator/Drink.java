package com.yang.other.design.decorator;

import lombok.Data;

/**
 * @ClassName Drink
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/2 下午8:15.
 */
@Data
public abstract class Drink {

    private String description;
    private float price = 0.0f;

    public abstract float cost();
}
