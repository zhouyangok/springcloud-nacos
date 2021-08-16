package com.authentication.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName IAuthenticationService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午5:23.
 */
@Service
public interface IAuthenticationService {
    /**
     * 校验权限
     *
     * @param authRequest
     * @return 是否有权限
     */
    boolean decide(HttpServletRequest authRequest);
}
