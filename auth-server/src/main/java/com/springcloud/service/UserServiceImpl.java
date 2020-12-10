package com.springcloud.service;

import com.springcloud.dto.UserDTO;
import com.springcloud.entity.JwtUser;
import com.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description: 用户管理业务类
 * @Author zhouyang
 * @Date 2020/9/15 下午10:00.
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    private List<UserDTO> userList;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //先查找user，再把user对象封装到JwtUser中来
        JwtUser user= new JwtUser();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("1"));
        return user;
    }
}
