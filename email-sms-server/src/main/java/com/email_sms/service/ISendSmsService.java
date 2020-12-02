package com.email_sms.service;

import java.util.Map;

public interface ISendSmsService {
    Map<String, Object> sendSms(String phone);
}
