package com.email_sms.controller;

import com.email_sms.service.ISendSmsService;
import com.springcloud.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhouyang
 * 短信服务
 */
@Api("阿里云短信服务")
@RestController
@RequestMapping("/sms")
@RefreshScope
public class SendSmsController {

    @Autowired(required = false)
    ISendSmsService sendSmsService;

    @ApiParam("阿里云发送短信服务")
    @GetMapping("/sendSms")
    public CommonResult sendSms(String phone) {
        Map<String, Object> map = sendSmsService.sendSms(phone);
        return CommonResult.success(map);
    }


    @Value("${aLiYun.signName}")
    private String signName;

    @GetMapping("/refreshConfig")
    public CommonResult refreshConfig() {
        String name = signName;
        return CommonResult.success(name);
    }

    @GetMapping("/test")
    public CommonResult test() {
        return CommonResult.success();
    }

}
