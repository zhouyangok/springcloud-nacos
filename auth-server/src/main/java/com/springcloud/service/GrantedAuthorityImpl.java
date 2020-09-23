package com.springcloud.service;

import org.springframework.security.core.GrantedAuthority;

/**
 * @ClassName GrantedAuthorityImpl
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/16 下午10:38.
 */

public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
