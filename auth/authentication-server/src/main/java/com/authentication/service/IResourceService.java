package com.authentication.service;

import com.authentication.po.Resource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @ClassName IResourceService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午5:23.
 */
@Service
public interface IResourceService {

    /**
     * 动态新增更新权限
     *
     * @param resource
     */
    void saveResource(Resource resource);

    /**
     * 动态删除权限
     *
     * @param resource
     */
    void removeResource(Resource resource);

    /**
     * 加载权限资源数据
     */
    void loadResource();

    /**
     * 根据url和method查询到对应的权限信息
     *
     * @param authRequest
     * @return
     */
    ConfigAttribute findConfigAttributesByUrl(HttpServletRequest authRequest);

    /**
     * 根据用户名查询 该用户所拥有的角色对应的资源信息
     *
     * @param username
     * @return
     */
    Set<Resource> queryByUsername(String username);
}
