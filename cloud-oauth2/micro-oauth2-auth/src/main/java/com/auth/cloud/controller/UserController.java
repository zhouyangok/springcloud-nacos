package com.auth.cloud.controller;

import com.auth.cloud.api.CommonResult;
import com.auth.cloud.service.VerificationCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/25 下午6:29.
 */
@RequestMapping("/code")
@RestController
@Api(tags = "UserController", description = "手机端用户登录注册管理")
public class UserController {


    @Autowired
    private VerificationCodeService verificationCodeService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return verificationCodeService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @PostMapping(value = "/verifyAuthCode")
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return verificationCodeService.verifyAuthCode(telephone,authCode);
    }

    @PostMapping("/test")
    @ResponseBody
    public CommonResult test(){
        return CommonResult.success("post");
    }
}
