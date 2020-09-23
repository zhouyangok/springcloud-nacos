package com.springcloud.stock.service;

import com.springcloud.entity.User;
import com.springcloud.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName userFeignService
 * @Description: 通过open-feign去调用
 * @Author zhouyang
 * @Date 2020/6/9 下午4:48.
 */
@Component
@FeignClient(value = "USER-SECURITY",fallback = UserFallback.class) //目标微服务的名称
public interface UserFeignService {

    //Feign接口中的方法要与目标服务中的Controller中的方法完全一致
    @PostMapping("/user/createUser")
    CommonResult createUser(@RequestBody User user);

    @GetMapping("/user/getById/{id}")
    CommonResult getUserById(@PathVariable(value = "id") Long id);

    @GetMapping("/feign/feignTimeout")
    String feignTimeout();

    @GetMapping("/hystrix/hyok")
    CommonResult ok(@RequestParam(value = "id") Long id);

    @GetMapping("/hystrix/hyerror")
    CommonResult error(@RequestParam(value = "id") Long id);
}
