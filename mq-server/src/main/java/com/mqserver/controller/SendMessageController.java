package com.mqserver.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import com.springcloud.exception.MyExceptionHandler;
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
 * @ClassName SendMessageController
 * @Description: direct exchange(直连型交换机)
 * @Author zhouyang
 * @Date 2020/9/22 下午10:08.
 */
@RestController
public class SendMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @GetMapping("/sendDirectMessage")
    public CommonResult sendDirectMessage() {
        for(int i =0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                        testMq();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        return CommonResult.success();
    }

    private CommonResult testMq(){
        try {
            String messageId = String.valueOf(UUID.randomUUID());
            String messageData =Thread.currentThread().getName() +"-----" + DateUtils.getNow() + " test message, hello!";
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String, Object> map = new HashMap<>();
            map.put("messageId", messageId);
            map.put("messageData", messageData);
            map.put("createTime", createTime);
            //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
            rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        }catch (Exception e){
            throw new MyExceptionHandler(20001,"消息发送失败");
        }
        return CommonResult.success();
    }
}
