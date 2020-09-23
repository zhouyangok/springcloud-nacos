package com.mqserver.controller;

import cn.hutool.core.lang.UUID;
import com.springcloud.result.CommonResult;
import com.springcloud.utils.DateUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SendTopcMessageController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/23 下午10:31.
 */
@RestController
public class SendTopicMessageController {
    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @GetMapping("/sendTopicMessage1")
    public CommonResult sendTopicMessage1(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: M A N ";
        String createTime = DateUtils.getNow();
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", manMap);
        return CommonResult.success();
    }

    @GetMapping("/sendTopicMessage2")
    public CommonResult sendTopicMessage2(){
        String messageId = UUID.randomUUID().toString();
        String messageData = "message: woman is all ";
        String createTime = DateUtils.getNow();
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", manMap);
        return CommonResult.success();
    }

}
