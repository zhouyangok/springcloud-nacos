package com.authorization.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName SmsCodeProviderFallback
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午4:09.
 */
@Component
public class SmsCodeProviderFallback implements SmsCodeProvider{

    @Autowired(required = false)
    PasswordEncoder passwordEncoder;

    @Override
    public String getSmsCode(String mobile, String businessType) {
        // 该类为mock, 目前暂时没有sms的服务
        return passwordEncoder.encode("123456");
    }
}
