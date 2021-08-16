package com.authentication.provider;

import com.authentication.po.Resource;
import com.springcloud.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ResourceProviderFallback
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午5:19.
 */
@Component
@Slf4j
public class ResourceProviderFallback implements ResourceProviderTmp {
    @Override
    public CommonResult<Set<Resource>> resources() {
        log.error("认证服务启动时加载资源异常！未加载到资源");
        return CommonResult.fail();
    }

    @Override
    public CommonResult<Set<Resource>> resources(String username) {
        log.error("认证服务查询用户异常！查询用户资源为空！");
        return CommonResult.success(new HashSet<Resource>());
    }

}
