/*
package com.springcloud.filter;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.entity.JwtUser;
import com.springcloud.result.CommonResult;
import com.springcloud.utils.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

*/
/**
 * @ClassName JWTLoginFilter
 * @Description: 自定义JWT登录过滤器
 *  验证用户名密码正确后，生成一个token，并将token返回给客户端
 *  该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
 *   attemptAuthentication ：接收并解析用户凭证。
 *  successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 * @Author zhouyang
 * @Date 2020/9/16 下午10:28.
 *//*


public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/auth/login");
    }

    // 认证成功(用户成功登录后，这个方法会被调用，我们在这个方法里生成token)
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        try {
            // 查看源代码会发现调用getPrincipal()方法会返回一个实现了`UserDetails`接口的对象
            // 所以就是JwtUser啦
            logger.info("auth:" + auth);
            boolean isRemember = true;

            // 因为在JwtUser中存了权限信息，可以直接获取，由于只有一个角色就这么干了
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            // 定义存放角色集合的对象
            List roleList = new ArrayList<>();
            for (GrantedAuthority grantedAuthority : authorities) {
                roleList.add(grantedAuthority.getAuthority());
            }
            //还应该加入权限信息
            String token = JwtUtil.createToken(auth.getName(),roleList, isRemember);
            // 返回创建成功的token
            // 但是这里创建的token只是单纯的token
            // 按照jwt的规定，最后请求的格式应该是 `Bearer token`
//        response.setHeader("token", JwtTokenUtils.TOKEN_PREFIX + token);
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(CommonResult.success(token)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 尝试身份认证(接收并解析用户凭证)
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            JwtUser user = new ObjectMapper().readValue(req.getInputStream(), JwtUser.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
*/
