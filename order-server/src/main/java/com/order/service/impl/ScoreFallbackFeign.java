package com.order.service.impl;


import com.order.service.ScoreServiceFeign;
import com.springcloud.entity.Score;
import com.springcloud.result.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @ClassName ScoreFallback
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/8 下午9:50.
 */

@Component
public class ScoreFallbackFeign implements ScoreServiceFeign {

    @Override
    public CommonResult createScore(Score score) {
        return CommonResult.fail("创建积分失败--接口错误，请联系管理员");
    }
}
