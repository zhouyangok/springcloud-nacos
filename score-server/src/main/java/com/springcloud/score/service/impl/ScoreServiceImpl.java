package com.springcloud.score.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.entities.Score;
import com.springcloud.result.CommonResult;
import com.springcloud.score.mapper.ScoreMapper;
import com.springcloud.score.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName ScoreService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/7 下午9:57.
 */
@Service
@Slf4j
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    @Override
    @HystrixCommand(fallbackMethod = "create_score_fallback")
    public CommonResult createScore(Score score) {
        int s=10/0;
        QueryWrapper<Score> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", score.getUserId());
        Score data = scoreMapper.selectOne(queryWrapper);
        if (data != null) {
            data.setScore(data.getScore() + score.getScore());
            scoreMapper.updateById(data);
            return CommonResult.success();
        }
        score.setCreateDate(DateUtil.date());
        scoreMapper.insert(score);
        return CommonResult.success();
    }



    @Override
    public CommonResult getScore(Integer userId) {
        QueryWrapper<Score> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        Score data = scoreMapper.selectOne(queryWrapper);
        return CommonResult.success(data);
    }


    public CommonResult create_score_fallback(){
        log.info("create_score_fallback-----服务出错，走到这里来了---");
        return CommonResult.fail(Thread.currentThread()+"运行异常");
    }

}