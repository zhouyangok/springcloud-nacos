package com.yang.other.design.decorator;

/**
 * @ClassName Decorator
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/2 下午8:23.
 */

public class Decorator extends Drink
{
    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        return super.getPrice()+obj.cost();
    }

    public String getDescription(){
        return super.getDescription()+"  "+super.getPrice()+"  "+obj.getDescription();
    }


}
