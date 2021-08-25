package com.auth.cloud.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.auth.cloud.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/17 上午9:01.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT u.id,u.user_name,u.password,u.status,r.name from t_user u left JOIN t_user_role ur on u.id = ur.user_id LEFT join t_role r on r.id = ur.role_id WHERE u.status=0 and u.user_name=#{username} ")
    List<User> getRoles(@Param("username")String username);
}
