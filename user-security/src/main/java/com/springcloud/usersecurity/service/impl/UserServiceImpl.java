package com.springcloud.usersecurity.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springcloud.entity.Order;
import com.springcloud.entity.Score;
import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.entity.User;
import com.springcloud.usersecurity.entity.UserRole;
import com.springcloud.usersecurity.mapper.UserMapper;
import com.springcloud.usersecurity.mapper.UserRoleMapper;
import com.springcloud.usersecurity.service.UserService;
import com.springcloud.usersecurity.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Resource
    private UserRoleMapper userRoleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public int createUser(UserVo user) {
        User user1 = new User();
        BeanUtil.copyProperties(user,user1);
        String password = passwordEncoder.encode(user.getPassword());
        user1.setPassword(password);
        //插入用户到数据表
        int result = userMapper.insert(user1);
        //插入角色到数据表
        userRoleMapper.saveBatchByUserId(user.getRoleIds(),user1.getUserId(),user.getCreateUserId());
        return result;
    }

    @Override
    public int updateUser(User user) {
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
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
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 0);
        IPage orderIPage = userMapper.selectPage(page, null);
        return CommonResult.success(orderIPage);
    }
}
