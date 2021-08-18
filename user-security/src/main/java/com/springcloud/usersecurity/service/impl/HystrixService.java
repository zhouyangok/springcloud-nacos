package com.springcloud.usersecurity.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName HystrixService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/6/24 下午4:54.
 */
@Service
@Slf4j
public class HystrixService {



    public String ok(Long id) {
        return "线程池:" + Thread.currentThread() + ",当前id:" + id;
    }

    @HystrixCommand(fallbackMethod = "error_handler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")})
    public String error(Long id){
//        int ss = 10/0;
        try {
            TimeUnit.SECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread() + ",当前id:" + id;
    }

    public String error_handler(Long id){
        return "线程池:" + Thread.currentThread()+",异常处理:error_handler" + ",当前id:" + id;
    }


//    ========服务熔断
    @HystrixCommand(fallbackMethod = "serviceCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸)
    })
    public String serviceCircuitBreaker(Long id){
        if(id<0){
            throw new RuntimeException("----id不能为负数----"+id);
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }


    public String serviceCircuitBreaker_fallback(Long id){
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
