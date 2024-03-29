package com.springcloud.usersecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.usersecurity.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName RoleMenuMapper
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/18 上午9:11.
 */

public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    List<Integer> selectMenuIdsByRoleId(Integer RoleId);

    @Select("select name from t_role tr where tr.status=0 and tr.id in(SELECT role_id from t_role_menu  tro where tro.menu_id=#{menuId} and tro.status=0)")
    List<String> getRolesByMenuId(@Param("menuId")Integer menuId);
}
