package com.authentication.events;

import com.authentication.po.Resource;
import com.authentication.service.impl.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @ClassName BusReceiver
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午5:05.
 */

@Component
@Slf4j
public class BusReceiver {

    @Autowired
    private ResourceService resourceService;

    public void handleMessage(Resource resource) {
        log.info("Received Message:<{}>", resource);
        resourceService.saveResource(resource);
    }
}
