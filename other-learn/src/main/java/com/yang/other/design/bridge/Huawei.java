package com.yang.other.design.bridge;

/**
 * @ClassName Huawei
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/3 下午7:15.
 */

public class Huawei implements Brand{

    @Override
    public void call() {
        System.out.println("huawei is calling~");
    }

    @Override
    public void open() {
        System.out.println("huawei is opening~");
    }

    @Override
    public void close() {
        System.out.println("huawei is closing~");
    }
}
