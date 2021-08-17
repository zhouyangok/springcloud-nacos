package com.springcloud.usersecurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springcloud.entity.Order;
import com.springcloud.entity.Score;
import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.entity.User;
import com.springcloud.usersecurity.mapper.UserMapper;
import com.springcloud.usersecurity.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/17 上午9:00.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public int createUser(User user) {
       int result = userMapper.insert(user);
        return result;
    }

    @Override
    public int updateUser(User user) {
        int result =  userMapper.updateById(user);
        return result;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }

    @Override
    public User getUserById(int id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 0);
        queryWrapper.eq("id", id);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public CommonResult getUserList(int pageNum,int pageSize) {
        Page<User> page = new Page<>(pageNum, pageSize);
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("status", 0);
        IPage orderIPage = userMapper.selectPage(page, null);
        return CommonResult.success(orderIPage);
    }
}
