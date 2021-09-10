package com.yang.other.design.decorator;


/**
 * @ClassName Drink
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/2 下午8:15.
 */
public abstract class Drink {

    private String description;
    private float price = 0.0f;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}
