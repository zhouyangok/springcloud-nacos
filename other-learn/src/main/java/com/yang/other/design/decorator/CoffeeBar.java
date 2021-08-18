package com.yang.other.design.decorator;

/**
 * @ClassName CoffeeBar
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/2 下午8:36.
 */

public class CoffeeBar {

    public static void main(String[] args) {
        Drink drink = new LongBlack();
        System.out.println(drink);
        drink = new Milk(drink);

        System.out.println(drink.getDescription());
        System.out.println(drink.cost());
    }
}
