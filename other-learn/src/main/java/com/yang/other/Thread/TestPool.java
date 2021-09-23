package com.yang.other.Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName TestPool
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/9/22 下午8:48.
 */

public class TestPool {
    public static void main(String[] args) {

    }

    public void testFixed(){
        Executor service = Executors.newFixedThreadPool(1);
    }
}
