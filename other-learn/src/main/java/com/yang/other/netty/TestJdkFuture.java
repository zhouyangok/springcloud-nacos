package com.yang.other.netty;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @ClassName TestJdkFuture
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/9/9 下午9:07.
 */
@Slf4j
public class TestJdkFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
//                logger.debug("执行计算");
                return 50;
            }
        });
//        logger.debug("等待结果");
//        logger.debug("计算完成,{}",future.get());
        future.get();
    }
}
