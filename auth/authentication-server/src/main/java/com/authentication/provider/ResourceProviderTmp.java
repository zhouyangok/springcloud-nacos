package com.authentication.provider;

import com.authentication.po.Resource;
import com.springcloud.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

/**
 * @ClassName ResourceProvider
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午5:16.
 */
@Component
@FeignClient(name = "organization", fallback = ResourceProviderFallback.class)
public interface ResourceProviderTmp {

    @GetMapping(value = "/resource/all")
    CommonResult<Set<Resource>> resources();

    @GetMapping(value = "/resource/user/{username}")
    CommonResult<Set<Resource>> resources(@PathVariable("username") String username);
}
