package com.springcloud.usersecurity.controller;

import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.service.impl.RedisServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName RedisController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/11 下午7:42.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisServerImpl redisServer;

    @GetMapping("/getRedisString")
    public CommonResult getRedisString(String param){
        Object result = redisServer.getRedisString(param);
        if(result!=null){
            return CommonResult.success(result);
        }
        return CommonResult.fail();
    }


    @GetMapping("/setRedisString")
    public CommonResult setRedisString(String param){
        String result = redisServer.redisString(param);
        if(result!=null){
            return CommonResult.success(result);
        }
        return CommonResult.fail();
    }

    @GetMapping("/setRedisList")
    public CommonResult setRedisList(String param){
        Boolean result = redisServer.redisList(param);
        if(result){
            return CommonResult.success();
        }
        return CommonResult.fail();
    }

    @GetMapping("/getRedisList")
    public CommonResult getRedisList(String param){
        List result = redisServer.getRedisList(param);
        if(!result.isEmpty()){
            return CommonResult.success(result);
        }
        return CommonResult.fail();
    }
}
