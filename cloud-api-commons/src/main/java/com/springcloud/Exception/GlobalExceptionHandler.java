package com.springcloud.Exception;

import com.springcloud.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GlobleException
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/11/26 下午8:23.
 */
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 全局异常处理
     * @param e
     * @return
     */

    @ExceptionHandler(Exception.class)
    public CommonResult error(Exception e){
        e.printStackTrace();
        log.info("执行了全部异常");
        return CommonResult.fail("程序异常");
    }


    /**
     * 特定异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public CommonResult error(NullPointerException e){
        e.printStackTrace();
        return CommonResult.fail("空指针异常");
    }


    /**
     * 自定义异常-需要主动try-catch抛出
     * @param e
     * @return
     */
    @ExceptionHandler(MyExceptionHandler.class)
    public CommonResult myException(MyExceptionHandler e){
        e.printStackTrace();
        log.info("执行了自定义异常");
        return CommonResult.fail(e.getMsg());
    }
}
