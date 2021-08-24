package com.springcloud.usersecurity.service;

import com.springcloud.usersecurity.entity.Menu;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MenuService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/18 上午9:12.
 */
@Service
public interface MenuService {

    int createMenu(Menu menu);

    int updateMenu(Menu menu);

    List<Menu> getMenuListByRoleId(int roleId);

    int deleteMenu(int menuId);

    List<Menu> getMenuPaths();

    List<String> getRolesByMenuId(Integer menuId);
}
