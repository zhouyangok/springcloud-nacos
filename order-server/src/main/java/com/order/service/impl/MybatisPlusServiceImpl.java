package com.order.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.order.entity.MyBatisPlus;
import com.order.mapper.MyBatisPlusMapper;
import com.order.service.MybatisPlusService;
import com.order.vo.MyBatisPlusVo;
import com.springcloud.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import java.sql.Wrapper;

/**
 * @ClassName MybatisPlusServiceImpl
 * @Description: mybatis测试服务层实现
 * @Author zhouyang
 * @Date 2020/12/5 下午8:36.
 */
@Service
public class MybatisPlusServiceImpl implements MybatisPlusService {

    @Resource
    private MyBatisPlusMapper myBatisPlusMapper;

    @Override
    public int delete(Long id) {
        int result = myBatisPlusMapper.deleteById(id);
        return result;
    }

    @Override
    @ExceptionHandler
    public int update(MyBatisPlus myBatisPlus) {
        int result = myBatisPlusMapper.updateById(myBatisPlus);
        return result;
    }

    @Override
    @ExceptionHandler
    public int save(MyBatisPlus myBatisPlus) {
        int result = myBatisPlusMapper.insert(myBatisPlus);
        return result;
    }

    @Override
    public CommonResult list(int pageSize, int pageNum, MyBatisPlusVo myBatisPlusVo) {

        Page<MyBatisPlus> page = new Page<>(pageNum, pageSize);
        IPage result = myBatisPlusMapper.selectPage(page, null);
        return CommonResult.success(result);
    }


    @Override
    public MyBatisPlus getById(Long id) {
        return myBatisPlusMapper.selectById(id);
    }
}
