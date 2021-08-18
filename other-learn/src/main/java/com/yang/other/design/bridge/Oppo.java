package com.yang.other.design.bridge;

/**
 * @ClassName Oppo
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/3 下午7:16.
 */

public class Oppo implements Brand{
    @Override
    public void call() {
        System.out.printf("Oppo is calling~");
    }

    @Override
    public void open() {
        System.out.println("Oppo is opening~");
    }

    @Override
    public void close() {
        System.out.println("Oppo is closing~");
    }
}
