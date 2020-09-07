package com.springcloud.usersecurity.controller;

import com.springcloud.result.CommonResult;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName GateWayTestController
 * @Description: 网关测试控制层
 * @Author zhouyang
 * @Date 2020/6/25 上午11:21.
 */
@RestController
@RequestMapping("/gatewayTest")
public class GateWayTestController {

    @GetMapping("/getResult/{id}")
    public CommonResult getResult(@PathVariable Long id) {
        if (id > 0) {
            return CommonResult.success(id);
        }
        return CommonResult.fail(id);
    }


    @PostMapping("/postResult")
    public CommonResult postResult(@RequestParam String name, @RequestParam Long id) {
        return CommonResult.success("name:" + name + ",id:" + id);
    }
}
