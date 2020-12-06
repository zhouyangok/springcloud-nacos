package com.order.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.order.entity.MyBatisPlus;
import com.order.mapper.MyBatisPlusMapper;
import com.order.service.MybatisPlusService;
import com.order.vo.MyBatisPlusVo;
import com.springcloud.result.CommonResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;

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
    public int update(MyBatisPlusVo myBatisPlusVo) {
        MyBatisPlus myBatisPlus = myBatisPlusMapper.selectById(myBatisPlusVo.getId());
        if (null != myBatisPlus) {
            BeanUtil.copyProperties(myBatisPlusVo, myBatisPlus);
            int result = myBatisPlusMapper.updateById(myBatisPlus);
            return result;
        }
        return 0;
    }

    @Override
    @ExceptionHandler
    public int save(MyBatisPlusVo myBatisPlusVo) {
        MyBatisPlus myBatisPlus = new MyBatisPlus();
        BeanUtil.copyProperties(myBatisPlusVo, myBatisPlus);
        int result = myBatisPlusMapper.insert(myBatisPlus);
        return result;
    }

    @Override
    public CommonResult list(int pageSize, int pageNum, MyBatisPlusVo myBatisPlusVo) {
        Page<MyBatisPlus> page = new Page<>(pageNum, pageSize);
        //构建查询条件
        QueryWrapper<MyBatisPlus> wrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(myBatisPlusVo.getName())) {
            wrapper.like("name", myBatisPlusVo.getName());
        }
        if (myBatisPlusVo.getAge() != null) {
            wrapper.eq("age", myBatisPlusVo.getAge());
        }
        if (StrUtil.isNotBlank(myBatisPlusVo.getStart())) {
            wrapper.ge("create_time", myBatisPlusVo.getStart());
        }
        if (StrUtil.isNotBlank(myBatisPlusVo.getEnd())) {
            wrapper.le("create_time", myBatisPlusVo.getEnd());
        }
        IPage result = myBatisPlusMapper.selectPage(page, wrapper);
        return CommonResult.success(result);
    }


    @Override
    public MyBatisPlus getById(Long id) {
        return myBatisPlusMapper.selectById(id);
    }
}
