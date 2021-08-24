package com.springcloud.usersecurity.controller;

import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.entity.Role;
import com.springcloud.usersecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public CommonResult createRole(@RequestBody Role role) {
        int result = roleService.createRole(role);
        if (result > 0) {
            return CommonResult.success();
        }
        return CommonResult.fail();
    }

    @PostMapping("/updateRole")
    public CommonResult updateRole(@RequestBody Role role) {
        int result = roleService.updateRole(role);
        if (result > 0) {
            return CommonResult.success();
        }
        return CommonResult.fail();
    }

    @GetMapping("/getRoleById/{id}")
    public CommonResult getRoleById(@PathVariable Integer id) {
        if (id != null && id > 0) {
            Role role = roleService.getRoleById(id);
            if (role != null) {
                return CommonResult.success(role);
            }
        }
        return CommonResult.fail();
    }

    @GetMapping("/getRoleByUserId/{userId}")
    public CommonResult getRolesByUserId(@PathVariable int userId){
        if(userId > 0){
            List<Role> results = roleService.getRoleListByUserId(userId);
            return CommonResult.success(results);
        }
        return CommonResult.fail();
    }

    @DeleteMapping("deleteRole/{id}")
    public CommonResult deleteRole(@PathVariable int id) {
        if (id > 0) {
            int result = roleService.deleteRole(id);
            if (result > 0) {
                return CommonResult.success();
            }
        }
        return CommonResult.fail();
    }

    @GetMapping("/getRoleList")
    public CommonResult getRoleList(@RequestParam int pageNum, @RequestParam int pageSize) {
        if (pageNum > 0 && pageSize > 0) {
            return roleService.getRoleList(pageNum, pageSize);
        }
        return CommonResult.fail();
    }
}
