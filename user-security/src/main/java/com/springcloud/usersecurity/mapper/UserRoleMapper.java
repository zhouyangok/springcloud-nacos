package com.springcloud.usersecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.usersecurity.entity.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName UserRoleMapper
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/17 下午9:38.
 */

public interface UserRoleMapper extends BaseMapper<UserRole> {

    @Select("select role_id from t_user_role where status=0 and user_id=#{userId}")
    List<Integer> getRoleIdsByUserId(@Param("userId") Integer userId);

    @Insert({"<script>",
            "insert into t_user_role(user_id,role_id,create_user_id)",
            "values",
            "<foreach collection='roleIds' item='item' separator=','>",
            "(#{userId},#{item},#{createUserId})",
            "</foreach>",
            "</script>"})
    int saveBatchByUserId(@Param("roleIds") List<Integer> roleIds, @Param("userId")int userId, @Param("createUserId") int createUserId);
}
