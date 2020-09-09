package com.springcloud.score.controller;

import com.springcloud.entities.Score;
import com.springcloud.result.CommonResult;
import com.springcloud.score.service.impl.ScoreServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UIController
 * @Description: 平台调用控制层
 * @Author zhouyang
 * @Date 2020/6/9 下午3:11.
 */
@RestController
@Slf4j
@RequestMapping("/score")
@Api(tags = "积分服务接口")
public class ScoreController {

    @Autowired
    private ScoreServiceImpl scoreService;

    @ApiOperation("新建用户积分")
    @PostMapping("/createScore")
    public CommonResult createScore(@RequestBody Score score) {
        if (score.getUserId() != null) {
            return scoreService.createScore(score);
        }
        return CommonResult.fail("参数错误");
    }

    @ApiOperation("根据用户id获取用户积分详情")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true)
    @GetMapping("/getScore/{userId}")
    public CommonResult getScore(@PathVariable Integer userId) {
        return scoreService.getScore(userId);
    }

}
