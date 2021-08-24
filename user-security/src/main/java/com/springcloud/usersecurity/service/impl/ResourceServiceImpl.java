package com.springcloud.usersecurity.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.springcloud.usersecurity.contant.RedisConstant;
import com.springcloud.usersecurity.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 资源与角色匹配关系管理业务类
 * Created by macro on 2020/6/19.
 */
@Service
public class ResourceServiceImpl {

    private Map<String, List<String>> resourceRolesMap;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Resource
    private MenuServiceImpl menuService;

    @PostConstruct
    public void initData() {
        List<Menu> menuPaths = menuService.getMenuPaths();
        resourceRolesMap = new TreeMap<>();
        if(!menuPaths.isEmpty()){
            menuPaths.forEach(menu -> {
                        List roles = menuService.getRolesByMenuId(menu.getId());
                resourceRolesMap.put(menu.getPath(), roles);
            });
        }
//        resourceRolesMap.put("/api/user/currentUser", CollUtil.toList("ADMIN", "TEST"));
        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
    }
}
