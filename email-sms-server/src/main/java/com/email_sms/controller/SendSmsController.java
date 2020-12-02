package com.email_sms.controller;

import com.email_sms.service.ISendSmsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author  zhouyang
 * 短信服务
 */
@Api("阿里云短信服务")
@Controller
@RequestMapping("/sms")
public class SendSmsController {

    @Autowired(required = false)
    ISendSmsService sendSmsService;

    @GetMapping("/sendSms")
    @ResponseBody
    public Map<String,Object> sendSms(String phone){
        return sendSmsService.sendSms(phone);
    }
}
