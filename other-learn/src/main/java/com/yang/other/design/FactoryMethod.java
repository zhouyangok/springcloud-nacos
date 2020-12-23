package com.yang.other.design;

/**
 * @ClassName FactoryMethod
 * @Description: 工厂方法模式
 * @Author zhouyang
 * @Date 2020/12/23 下午9:23.
 */

public class FactoryMethod {

    public static void main(String[] args) {
        Application application = new ConcreteProductA();
        Product productA = application.getObject();
        productA.method();
        System.out.println(productA);
    }
}

interface Product {
    void method();
}

class ProductA implements Product {

    public void method() {
        System.out.println("A打印了...");
    }
}

class ProductB implements Product {
    public void method() {
        System.out.println("B打印了...");
    }
}

/**
 * 简单工厂模式
 */
class SimpleFactory {
    public static Product createProduct(int type) {
        if (type == 0) {
            return new ProductA();
        } else {
            return new ProductB();
        }
    }
}

//class Application {
//    private Product createProductA(int type) {
//        return SimpleFactory.createProduct(type);
//    }
//
//    Product getObject(int type) {
//        Product product = createProductA(type);
//        return product;
//    }
//}

abstract class Application {
    abstract Product createProduct();

    Product getObject() {
        Product product = createProduct();
        return product;
    }
}

class ConcreteProductA extends Application{

    @Override
    Product createProduct() {
        return new ProductA();
    }
}

class ConcreteProductB extends Application{

    @Override
    Product createProduct() {
        return new ProductB();
    }
}