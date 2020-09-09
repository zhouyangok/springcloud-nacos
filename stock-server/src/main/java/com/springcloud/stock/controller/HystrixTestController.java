package com.springcloud.stock.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.stock.service.UserFeignService;
import com.springcloud.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName HystrixTestController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/6/24 下午5:00.
 */
@RestController
@RequestMapping("/hystrixTest")
@Slf4j
public class HystrixTestController {

    @Resource
    private UserFeignService userFeignService;

    @GetMapping("/hyok")
    CommonResult ok(@RequestParam Long id) {
        return userFeignService.ok(id);
    }

    @GetMapping("/hyerror")
//    @HystrixCommand(fallbackMethod = "error_handler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")})
    @HystrixCommand
    CommonResult error(@RequestParam Long id) {
//        try {
//            TimeUnit.SECONDS.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return userFeignService.error(id);
    }

    public CommonResult error_handler(Long id) {
        String ss = "线程池:" + Thread.currentThread() + ",对方服务忙，请稍后再试:error_handler" + ",当前id:" + id;
        return CommonResult.success(ss);
    }
}
