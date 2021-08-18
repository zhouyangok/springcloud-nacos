package com.springcloud.usersecurity.service.impl;

import cn.hutool.core.convert.Convert;
import com.springcloud.usersecurity.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName RedisServerImpl
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/11 下午7:42.
 */
@Service
public class RedisServerImpl {

    @Resource
    RedisUtil redisUtil;

    public String redisString(String param){
        redisUtil.set(param,param.hashCode());
        return param;
    }

    public Object getRedisString(String param){
        Object o =  redisUtil.get(param);
        return o;
    }

    public Boolean redisList(String param){
        List list = Convert.toList(param);
       Boolean result = redisUtil.lSet(param,list);
     return result;
    }

    public List getRedisList(String param){
        List list = redisUtil.lGet(param,0,-1);
        return list;
    }
}
