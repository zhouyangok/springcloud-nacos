package com.springcloud.usersecurity.controller;

import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.entity.Menu;
import com.springcloud.usersecurity.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName MenuController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/18 上午9:10.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    @PostMapping("/create")
    public CommonResult createMenu(@RequestBody Menu menu){
        int result = menuService.createMenu(menu);
        if(result>0){
            return CommonResult.success();
        }
        return CommonResult.fail();
    }
}
