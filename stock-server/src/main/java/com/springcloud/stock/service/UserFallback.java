package com.springcloud.stock.service;

import com.springcloud.entity.User;
import com.springcloud.result.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserFallback
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/6/24 下午5:59.
 */
@Component
public class UserFallback implements UserFeignService {
    @Override
    public CommonResult createUser(User user) {
        return CommonResult.fail("接口错误，请稍后再试");
    }

    @Override
    public CommonResult getUserById(Long id) {
        return CommonResult.fail("getUserById---接口错误，请稍后再试");
    }

    @Override
    public String feignTimeout() {
        return "feignTimeout---接口错误，请稍后再试";
    }

    @Override
    public CommonResult ok(Long id) {
        return CommonResult.fail("ok---接口错误，请稍后再试");
    }

    @Override
    public CommonResult error(Long id) {
        return CommonResult.fail("error---接口错误，请稍后再试");
    }
}
