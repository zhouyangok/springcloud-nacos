package com.springcloud.usersecurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springcloud.usersecurity.entity.Role;
import com.springcloud.usersecurity.mapper.RoleMapper;
import com.springcloud.usersecurity.mapper.UserRoleMapper;
import com.springcloud.usersecurity.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/17 下午9:41.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public int createRole(Role role) {
        int result = roleMapper.insert(role);
        return result;
    }

    @Override
    public int updateRole(Role role) {
        return 0;
    }

    @Override
    public int deleteRole(int id) {
        return 0;
    }

    @Override
    public Role getRoleById(Integer id) {
        QueryWrapper<Role> wrapper = new QueryWrapper();
        wrapper.eq("id",id);
        wrapper.eq("status",0);
        return roleMapper.selectOne(wrapper);
    }

    @Override
    public List<Role> getRoleList(int pageNum, int pageSize) {
        return null;
    }
}
