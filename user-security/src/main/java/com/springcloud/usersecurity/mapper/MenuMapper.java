package com.springcloud.usersecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.usersecurity.entity.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName MenuMapper
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/18 上午9:11.
 */

public interface MenuMapper extends BaseMapper<Menu> {

    @Select("select distinct path,id from t_menu where status=0")
    List<Menu> getMenuPaths();
}
