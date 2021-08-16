package com.authorization.service;


import com.authorization.entity.Role;
import org.springframework.stereotype.Service;

import java.util.Set;
/**
 * @ClassName IRoleService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午1:12.
 */

@Service
public interface IRoleService {

    Set<Role> queryUserRolesByUserId(String userId);

}