package com.springcloud.usersecurity.service;

import com.springcloud.entity.Score;
import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.service.impl.MqFallbackFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName MqServiceFeign
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/12 上午8:43.
 */
@FeignClient(value = "mq-server",path = "/sendDirectMessage",fallback = MqFallbackFeign.class)
public interface MqServiceFeign {

    @GetMapping("/sendDirectMessage")
     CommonResult sendDirectMessage();
}
