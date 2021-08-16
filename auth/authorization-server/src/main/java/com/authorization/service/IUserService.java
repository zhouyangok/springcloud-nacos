package com.authorization.service;

import com.authorization.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName IUserService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午1:13.
 */
@Service
public interface IUserService {
    /**
     * 根据用户唯一标识获取用户信息
     *
     * @param uniqueId
     * @return
     */
    @Cacheable(value = "#id")
    User getByUniqueId(String uniqueId);
}
