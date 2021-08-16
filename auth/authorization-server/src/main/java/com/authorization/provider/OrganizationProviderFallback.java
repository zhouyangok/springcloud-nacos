package com.authorization.provider;

import com.authorization.entity.Role;
import com.authorization.entity.User;
import com.springcloud.result.CommonResult;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName OrganizationProviderFallback
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午4:07.
 */
@Component
public class OrganizationProviderFallback implements OrganizationProvider{
    @Override
    public CommonResult<User> getUserByUniqueId(String uniqueId) {
        return CommonResult.success(new User());
    }

    @Override
    public CommonResult<Set<Role>> queryRolesByUserId(String userId) {
        return CommonResult.success(new HashSet<Role>());
    }
}
