package com.authorization.oauth2.granter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
/**
 * @ClassName MobileAuthenticationToken
 * @Description: 手机验证码登陆Token认证类
 * @Author zhouyang
 * @Date 2021/8/14 下午12:58.
 */

public class MobileAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public MobileAuthenticationToken(Authentication authenticationToken) {
        super(authenticationToken.getPrincipal(), authenticationToken.getCredentials());
    }
}
