package com.springcloud.score.service;

import com.springcloud.entities.User;
import com.springcloud.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName userFeignService
 * @Description: 通过open-feign去调用
 * @Author zhouyang
 * @Date 2020/6/9 下午4:48.
 */
@Component
@FeignClient(value = "user-security") //目标微服务的名称
public interface ScoreFeignService {

    //Feign接口中的方法要与目标服务中的Controller中的方法完全一致
    @PostMapping("/user/createUser")
    CommonResult createUser(@RequestBody User user);

    @GetMapping("/user/getById/{id}")
    CommonResult getUserById(@PathVariable Long id);
}
