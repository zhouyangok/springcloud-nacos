package com.springcloud.score.service;

import com.springcloud.entity.Score;
import com.springcloud.result.CommonResult;

/**
 * @ClassName ScoreService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/8 下午9:56.
 */

public interface ScoreService {
    CommonResult createScore(Score score);

    CommonResult getScore(Integer userId);
}
