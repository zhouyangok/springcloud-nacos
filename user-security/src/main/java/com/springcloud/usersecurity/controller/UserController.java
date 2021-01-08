package com.springcloud.usersecurity.controller;

import cn.hutool.core.util.StrUtil;
import com.springcloud.entity.User;
import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.vo.UserVo;
import io.swagger.annotations.Api;
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
@Api(value = "用户管理")
public class UserController {


    @PostMapping("/createUser")
    public CommonResult createUser(@RequestBody User user) {
        log.info("id:{},name:{}", user.getId(), user.getUsername());
        return CommonResult.success();
    }

    @GetMapping("/getById/{id}")
    public CommonResult getUserById(@PathVariable Long id) {
        log.info("id:{}", id);
        User user = new User(1L, "admin","","");
        return CommonResult.success(user);
    }


    @PostMapping("/login")
    public CommonResult login(@RequestBody UserVo userVo){
        if(StrUtil.equals(userVo.getUserName(),"admin")&&StrUtil.equals(userVo.getPassword(),"1")){
            userVo.setUserId(1L);
            userVo.setAvatar("/avatar/admin.jpg");
            return CommonResult.success(userVo);
        }
        return CommonResult.fail("用户名或密码错误");
    }
}
