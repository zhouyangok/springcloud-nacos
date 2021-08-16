package com.springcloud.usersecurity.controller;

import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.service.impl.MqServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MQController
 * @Description: Test MQ
 * @Author zhouyang
 * @Date 2021/8/12 上午8:42.
 */
@RestController
@RequestMapping("/mq")
public class MQController {
    @Autowired
    private MqServiceImpl mqService;

    @GetMapping("/sendMqMessage")
    public CommonResult sendMqMessage(String params){
        CommonResult result =mqService.sendMessage(params);
        return result;
    }
}
