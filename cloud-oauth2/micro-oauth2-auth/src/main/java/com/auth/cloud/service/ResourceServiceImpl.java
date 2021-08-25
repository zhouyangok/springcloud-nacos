package com.auth.cloud.service;

import com.auth.cloud.constant.RedisConstant;
import com.auth.cloud.entity.Menu;
import com.auth.cloud.mapper.RoleMenuMapper;
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

//    private Map<String, List<String>> resourceRolesMap;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private RoleMenuMapper roleMenuMapper;

    //    @PostConstruct
//    public void initData() {
//        resourceRolesMap = new TreeMap<>();
//        resourceRolesMap.put("/api/hello", CollUtil.toList("ADMIN"));
//        resourceRolesMap.put("/api/user/currentUser", CollUtil.toList("ADMIN", "TEST"));
//        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
//    }
    @PostConstruct
    public void initData() {
        List<Menu> menuPaths = this.getMenuPaths();
        Map<String, List<String>> resourceRolesMap = new TreeMap<>();
        if (!menuPaths.isEmpty()) {
            menuPaths.forEach(menu -> {
                List roles = this.getRolesByMenuId(menu.getId());
                resourceRolesMap.put(menu.getPath(), roles);
            });
        }
        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
    }
    public List<Menu> getMenuPaths(){
        return roleMenuMapper.getMenuPaths();
    }

    public List<String> getRolesByMenuId(Integer id){
        return roleMenuMapper.getRolesByMenuId(id);
    }
}
