package com.auth.cloud.service;

import com.auth.cloud.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName VerificationCodeService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/25 下午8:44.
 */
@Service
public class VerificationCodeService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisTemplate.opsForValue().set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisTemplate.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS, TimeUnit.SECONDS);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }


    //对输入的验证码进行校验
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        Object o = redisTemplate.opsForValue().get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        if (null != o) {
            String realAuthCode = o.toString();
            boolean result = authCode.equals(realAuthCode);
            if (result) {
                return CommonResult.success(null, "验证码校验成功");
            }
        }
        return CommonResult.failed("验证码不正确");
    }
}
