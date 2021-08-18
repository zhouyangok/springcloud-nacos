package com.springcloud.usersecurity.service;

import com.springcloud.usersecurity.entity.Menu;
import org.springframework.stereotype.Service;

/**
 * @ClassName MenuService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/18 上午9:12.
 */
@Service
public interface MenuService {

    int createMenu(Menu menu);
}
