package com.springcloud.usersecurity.service.impl;

import com.springcloud.usersecurity.entity.Menu;
import com.springcloud.usersecurity.mapper.MenuMapper;
import com.springcloud.usersecurity.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Override
    public int createMenu(Menu menu) {
        return menuMapper.insert(menu);
    }
}
