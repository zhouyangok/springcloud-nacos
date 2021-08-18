package com.springcloud.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CommonResult
 * @Description: 通用返回类
 * @Author zhouyang
 * @Date 2020/6/9 下午2:46.
 */
@Data
@AllArgsConstructor //全参构造器
@NoArgsConstructor //空参构造器
public class    CommonResult<T> {
    private Integer code;
    private String message;
    private boolean status;
    private T data;

    public CommonResult(Integer code, String message,boolean status) {
        this(code, message, status,null);
    }


    public static CommonResult success(){
        return new CommonResult(200,"成功",true);
    }

    public static CommonResult fail(){
        return new CommonResult(400,"失败",false);
    }

    public static<T> CommonResult fail(T data){
        return new CommonResult(400,"失败",false,data);
    }

    public static<T> CommonResult fail(T data,T message){
        return new CommonResult(400,"失败",false,data);
    }

    public static <T> CommonResult success(T data){
        return new CommonResult(200,"成功",true,data);
    }
}
