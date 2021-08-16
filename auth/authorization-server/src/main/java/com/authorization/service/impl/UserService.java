package com.authorization.service.impl;

import com.authorization.entity.User;
import com.authorization.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午1:15.
 */
@Service
public class UserService implements IUserService {
    @Override
    public User getByUniqueId(String uniqueId) {
        return null;
    }
}
