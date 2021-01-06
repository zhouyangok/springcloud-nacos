package com.order.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName CustomMultiThreadingService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/1/6 下午9:51.
 */
@Service
@Slf4j
public class CustomMultiThreadingService {

    /*
    如何让异步调用的执行任务使用这个线程池中的资源来运行呢？方法非常简单，我们只需要在@Async注解中指定线程池名即可
     */

    @Async("nbpiTaskExecutor")
    public void executeAysncTask(Integer i) throws InterruptedException {
        log.info("CustomMultiThreadingService ==> executeAysncTask1 method: 执行异步任务{} ", i);
        Thread.sleep(500L);
    }
}
