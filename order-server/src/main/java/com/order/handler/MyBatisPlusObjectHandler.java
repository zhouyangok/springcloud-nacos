package com.order.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @ClassName MyBatisPlusObjectHandler
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/12/5 下午9:25.
 */
@Component
@Slf4j
public class MyBatisPlusObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.setFieldValByName( "createTime", LocalDateTime.now(),metaObject);
        this.setFieldValByName( "updateTime", LocalDateTime.now(),metaObject);

        this.setFieldValByName("version",1,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName( "updateTime", LocalDateTime.now(),metaObject);
    }
}
