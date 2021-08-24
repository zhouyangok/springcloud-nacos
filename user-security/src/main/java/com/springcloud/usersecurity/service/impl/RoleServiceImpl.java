package com.springcloud.usersecurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springcloud.result.CommonResult;
import com.springcloud.usersecurity.entity.Role;
import com.springcloud.usersecurity.entity.User;
import com.springcloud.usersecurity.mapper.RoleMapper;
import com.springcloud.usersecurity.mapper.UserRoleMapper;
import com.springcloud.usersecurity.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        if (null != role.getId()) {
            int result = roleMapper.updateById(role);
            return result;
        }
        return 0;
    }

    @Override
    public int deleteRole(int id) {
        if (id > 0) {
            Role role = this.getRoleById(id);
            if (role != null) {
                role.setStatus(-1);
                int result = this.updateRole(role);
                return result;
            }
        }
        return 0;
    }

    @Override
    public Role getRoleById(Integer id) {
        QueryWrapper<Role> wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        wrapper.eq("status", 0);
        return roleMapper.selectOne(wrapper);
    }

    @Override
    public List<Role> getRoleListByUserId(Integer userId) {
        List<Role> roles = new ArrayList<>();
        List<Integer> roleIds = userRoleMapper.getRoleIdsByUserId(userId);
        if (!roleIds.isEmpty()) {
            QueryWrapper<Role> wrapper = new QueryWrapper<>();
            wrapper.eq("status", 0).in("id", roleIds);
            roles = roleMapper.selectList(wrapper);
        }
        return roles;
    }

    @Override
    public CommonResult getRoleList(int pageNum, int pageSize) {
        Page<Role> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Role> wrapper = new QueryWrapper();
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 0);
        IPage orderIPage = roleMapper.selectPage(page, null);
        return CommonResult.success(orderIPage);
    }
}
