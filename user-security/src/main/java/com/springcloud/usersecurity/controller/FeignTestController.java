package com.springcloud.usersecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName FeignTestController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/6/24 下午4:27.
 */
@RestController
@Slf4j
@RequestMapping("/feign")
public class FeignTestController {


    @GetMapping("/feignTimeout")
    public String feignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "timeout";
    }
}
