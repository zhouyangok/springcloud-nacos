package com.springcloud.usersecurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springcloud.usersecurity.entity.Menu;
import com.springcloud.usersecurity.entity.RoleMenu;
import com.springcloud.usersecurity.mapper.MenuMapper;
import com.springcloud.usersecurity.mapper.RoleMenuMapper;
import com.springcloud.usersecurity.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName MenuServiceImpl
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/18 上午9:13.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Override
    public int createMenu(Menu menu) {
        return menuMapper.insert(menu);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateById(menu);
    }

    @Override
    public List<Menu> getMenuListByRoleId(int roleId) {
        //通过roleMenu中查出该role对应的权限
        QueryWrapper<RoleMenu> rmWrapper = new QueryWrapper<>();
        rmWrapper.select("menu_id").eq("role_id", roleId).eq("status", 0);
        List<Integer> idList = roleMenuMapper.selectList(rmWrapper).stream().map(RoleMenu::getMenuId).collect(Collectors.toList());
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("status", 0);
        wrapper.in("id", idList);
        List<Menu> menus = menuMapper.selectList(wrapper);
        return menus;
    }

    @Override
    public int deleteMenu(int menuId) {
        if (menuId > 0) {
            QueryWrapper<Menu> wrapper = new QueryWrapper<>();
            wrapper.eq("status", 0).eq("menu_id", menuId);
            Menu menu = menuMapper.selectOne(wrapper);
            if (menu != null) {
                menu.setStatus(-1);
                int result = menuMapper.updateById(menu);
                return result;
            }
        }
        return 0;
    }

    @Override
    public List<Menu> getMenuPaths() {
        return menuMapper.getMenuPaths();
    }

    @Override
    public List<String> getRolesByMenuId(Integer menuId) {
        return roleMenuMapper.getRolesByMenuId(menuId);
    }


}
