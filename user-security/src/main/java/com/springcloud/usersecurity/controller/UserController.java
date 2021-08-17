package com.springcloud.usersecurity.controller;

import cn.hutool.core.util.StrUtil;
import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.entity.User;
import com.springcloud.usersecurity.service.UserService;
import com.springcloud.usersecurity.vo.UserVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description: 用户控制层
 * @Author zhouyang
 * @Date 2020/6/9 下午2:46.
 */

@RestController
@Slf4j
@RequestMapping("/user")
@Api(value = "用户管理")
public class UserController {

    @Value("${server.port}")
    private String port;
    @Resource
    private UserService userService;


    @PostMapping("/createUser")
    public CommonResult createUser(@RequestBody User user) {
        log.info("id:{},name:{}", user.getUserId(), user.getUsername());
        int result = userService.createUser(user);
        if (result > 0) {
            return CommonResult.success();
        }
        return CommonResult.fail();
    }

    @PostMapping("/updateUser")
    public CommonResult updateUser(@RequestBody User user) {
        if (null != user.getUserId()) {
            int result = userService.updateUser(user);
            if (result > 0) {
                return CommonResult.success();
            }
        }
        return CommonResult.fail();
    }

    @GetMapping("/getById/{id}")
    public CommonResult getUserById(@PathVariable Integer id) {
        log.info("id:{}", id);
        User user = userService.getUserById(id);
        return CommonResult.success(user);
    }

    @GetMapping("/getUserList")
    public CommonResult getUserList(@RequestParam int pageNum, @RequestParam int pageSize) {
        return userService.getUserList(pageNum, pageSize);
    }

    @DeleteMapping("/deleteUser/{id}")
    public CommonResult deleteUser(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        if (null != user) {
            user.setStatus(-1);
            int result = userService.updateUser(user);
            if (result > 0) {
                return CommonResult.success();
            }
        }
        return CommonResult.fail();
    }


}
