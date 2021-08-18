package com.springcloud.usersecurity.service;

import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.entity.User;
import com.springcloud.usersecurity.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/17 上午8:58.
 */
@Service
public interface UserService {
    int createUser(UserVo user);

    int updateUser(User user);

    int deleteUser(int id);

    User getUserById(int id);

    CommonResult getUserList(int pageNum, int pageSize);
}
