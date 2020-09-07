package com.springcloud.usersecurity.controller;

import com.springcloud.entities.User;
import com.springcloud.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description: 用户控制层
 * @Author zhouyang
 * @Date 2020/6/9 下午2:46.
 */

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {


    @PostMapping("/createUser")
    public CommonResult createUser(@RequestBody User user) {
        log.info("id:{},name:{}", user.getId(), user.getName());
        return CommonResult.success();
    }

    @GetMapping("/getById/{id}")
    public CommonResult getUserById(@PathVariable Long id) {
        log.info("id:{}", id);
        User user = new User(1L, "admin");
        return CommonResult.success(user);
    }
}
