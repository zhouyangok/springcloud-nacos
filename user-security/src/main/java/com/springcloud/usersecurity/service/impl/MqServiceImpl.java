package com.springcloud.usersecurity.service.impl;

import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.service.MqServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName MqServiceImpl
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/12 上午8:49.
 */
@Service
@Slf4j
public class MqServiceImpl {
    @Resource
    private MqServiceFeign mqServiceFeign;

    public CommonResult sendMessage(String params){
        log.info("params:{}",params);
        CommonResult result = mqServiceFeign.sendDirectMessage();
        return result;
    }
}
