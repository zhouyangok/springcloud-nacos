package com.springcloud.usersecurity.service.impl;

import com.springcloud.entity.Score;
import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.service.MqServiceFeign;
import org.springframework.stereotype.Component;

/**
 * @ClassName MqFallbackFeign
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/12 上午8:44.
 */
@Component
public class MqFallbackFeign implements MqServiceFeign {

    @Override
    public CommonResult sendDirectMessage() {
        return CommonResult.fail("mq消息发送失败，请联系管理员");
    }
}
