package com.springcloud.stock.controller;

import com.springcloud.stock.service.UserFeignService;
import com.springcloud.result.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OpenFeignController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/6/23 下午5:12.
 */
@RestController
public class OpenFeignController {

    @Resource
    private UserFeignService userFeignService;

    @GetMapping("/consumer/getFeign/{id}")
    public CommonResult getFeign(@PathVariable Long id) {
        return  userFeignService.getUserById(id);
    }

    @GetMapping("/feignTimeout")
    public CommonResult feignTimeout(){
        return CommonResult.success(userFeignService.feignTimeout());
    }
}
