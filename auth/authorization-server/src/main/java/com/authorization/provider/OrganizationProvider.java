package com.authorization.provider;

import com.authorization.entity.Role;
import com.authorization.entity.User;
import com.springcloud.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 * @ClassName OrganizationProvider
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午4:05.
 */
@FeignClient(name = "organization", fallback = OrganizationProviderFallback.class)
public interface OrganizationProvider {
    @GetMapping(value = "/user")
    CommonResult<User> getUserByUniqueId(@RequestParam("uniqueId") String uniqueId);

    @GetMapping(value = "/role/user/{userId}")
    CommonResult<Set<Role>> queryRolesByUserId(@PathVariable("userId") String userId);
}
