package com.order.service;

import com.order.entity.MyBatisPlus;
import com.order.vo.MyBatisPlusVo;
import com.springcloud.result.CommonResult;

/**
 * @ClassName MybatisPlusService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/12/5 下午8:36.
 */

public interface MybatisPlusService {
    int delete(Long id);

    int update(MyBatisPlus myBatisPlus);

    int save(MyBatisPlus myBatisPlus);

    CommonResult list(int pageSize,int pageNum,MyBatisPlusVo myBatisPlusVo);

    MyBatisPlus getById(Long id);
}
