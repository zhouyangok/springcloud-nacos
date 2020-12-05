package com.order.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.order.entity.MyBatisPlus;
import com.order.service.MybatisPlusService;
import com.order.vo.MyBatisPlusVo;
import com.springcloud.exception.MyExceptionHandler;
import com.springcloud.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyBatisPlusTestController
 * @Description: todo
 * @Author zhouyang
 * @Date 2020/12/4 下午9:35.
 */
@Api(tags = "mybatisPlus接口学习")
@RestController
@RequestMapping("/mybatisPlus")
public class MyBatisPlusTestController {

    @Autowired
    private MybatisPlusService mybatisPlusService;

    @ApiOperation("根据id获取实体类")
    @GetMapping("/getById/{id}")
    public CommonResult getById(@PathVariable Long id) {
        try {
            return CommonResult.success(mybatisPlusService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyExceptionHandler(20001, "根据id:" + id + "获取失败");
        }
    }

    @ApiOperation("分页查询实体类")
    @PostMapping("/listByPage/{pageSize}/{pageNum}")
    public CommonResult listByPage(@PathVariable int pageSize,@PathVariable int pageNum, MyBatisPlusVo myBatisPlusVo) {
        try {
            return mybatisPlusService.list(pageSize,pageNum,myBatisPlusVo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyExceptionHandler(20001, "获取分页列表失败");
        }

    }

    @ApiOperation("批量查询")
    @GetMapping("/getBatch")
    public CommonResult getBatch(){
        return CommonResult.success();
    }


    @ApiOperation("保存实体类")
    @PostMapping("/save")
    public CommonResult save(@RequestBody MyBatisPlus myBatisPlus) {
        int result = mybatisPlusService.save(myBatisPlus);
        if (result > 0) {
            return CommonResult.success();
        }
        return CommonResult.fail();
    }

    @ApiOperation("更新实体类")
    @PostMapping("/update")
    public CommonResult update(@RequestBody MyBatisPlus myBatisPlus){
        int result = mybatisPlusService.update(myBatisPlus);
        if (result > 0) {
            return CommonResult.success();
        }
        return CommonResult.fail();
    }

    /**
     * 单个删除/批量删除
     * 逻辑删除
     * @param id
     * @return
     */
    @ApiOperation("删除实体类")
    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id){
        int result = mybatisPlusService.delete(id);
        if (result > 0) {
            return CommonResult.success();
        }
        return CommonResult.fail();
    }
}
