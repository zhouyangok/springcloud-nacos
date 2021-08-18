package com.springcloud.usersecurity.controller;

import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.service.impl.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName HystrixController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/6/24 下午4:53.
 */
@RestController
@RequestMapping("/hystrix")
@Slf4j
public class HystrixController {

    @Resource
    private HystrixService hystrixService;

    @GetMapping("/hyok")
    public CommonResult ok(@RequestParam Long id) {
        return CommonResult.success(hystrixService.ok(id));
    }

    @GetMapping("/hyerror")
    public CommonResult error(@RequestParam Long id) {
        return CommonResult.success(hystrixService.error(id));
    }

    //    服务熔断
    @GetMapping("/serviceCircuitBreaker")
    public String serviceCircuitBreaker(@RequestParam Long id) {
        return hystrixService.serviceCircuitBreaker(id);
    }
}
