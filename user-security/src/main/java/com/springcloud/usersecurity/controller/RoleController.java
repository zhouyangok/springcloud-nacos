package com.springcloud.usersecurity.controller;

import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.entity.Role;
import com.springcloud.usersecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName RoleController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/17 下午9:44.
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/createRole")
    public CommonResult createRole(@RequestBody Role role){
        int result = roleService.createRole(role);
        if(result>0){
            return CommonResult.success();
        }
        return CommonResult.fail();
    }

    @GetMapping("/getRoleById/{id}")
    public CommonResult getRoleById(@PathVariable Integer id){
        if(id!=null && id>0){
            Role role = roleService.getRoleById(id);
            if(role!=null){
                return CommonResult.success(role);
            }
        }
        return CommonResult.fail();
    }
}
