package com.springcloud.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName MyExceptionHandler
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/11/26 下午8:32.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyExceptionHandler  extends RuntimeException{

    private Integer code;

    private String msg;
}
