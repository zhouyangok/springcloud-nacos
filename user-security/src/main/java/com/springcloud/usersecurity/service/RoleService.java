package com.springcloud.usersecurity.service;

import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/17 下午9:39.
 */
@Service
public interface RoleService {
    int createRole(Role role);

    int updateRole(Role role);

    int deleteRole(int id);

    Role getRoleById(Integer id);

    CommonResult getRoleList(int pageNum, int pageSize);
}
