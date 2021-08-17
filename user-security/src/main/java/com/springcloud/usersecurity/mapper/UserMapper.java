package com.springcloud.usersecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.usersecurity.entity.User;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserMapper
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/17 上午9:01.
 */
@Component
public interface UserMapper  extends BaseMapper<User> {
}
