package com.email_sms.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.email_sms.config.sms.ALiYunConfig;
import com.email_sms.service.ISendSmsService;
import com.springcloud.utils.VerificationUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.email_sms.config.sms.ALiYunConfig.getMsgCode;


/**
 * @author zhouyang
 */
@Service
public class SendSmsServiceImpl implements ISendSmsService {


    public Map<String, Object> sendSms(String phone) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (VerificationUtil.isMobileNO(phone)) {
                map.put("code", 500);
                map.put("msg", "请输入正确的手机号码。");
                return map;
            }
            String code = getMsgCode();
            SendSmsResponse sendSmsResponse = ALiYunConfig.sendSms(phone, code);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                map.put("code", 200);
                map.put("msgCode", code);
                map.put("msg", "短信发送成功。");
            } else {
                map.put("code", 301);
                map.put("msg", sendSmsResponse.getMessage());
            }

        } catch (ClientException e) {
            e.printStackTrace();
            map.put("code", 500);
            map.put("msg", "短信发送失败。");
        }
        return map;
    }
}
