##先决条件：
1. java1.8
2. maven
3. mysql
4. redis
5. nacos
6. rabbitmq
7.git
---
##技术选型  
1. 服务注册中心 alibaba-nacos  
2. 数据持久化 mysql
3. 缓存 redis
4. 大数据索引查询 elasticsearch
5. 消息中心 rabbitmq
6. 短信服务  alibaba-sms
7. 文件存储 alibaba-oso

##更新内容
2020-12-05  
启动问题：com.alibaba.nacos.api.exception.NacosException: endpoint is blank
  原因：common包中，添加了nacos的配置依赖，而当前服务中没有用到。  
2020-12-06  
将order-server中配置放在nacos的配置文件中；  
添加mybatisPlus条件查询；  
添加配置文件，打印mybatis的sql日志
2020-12-14 添加spring-security,jwt登录权限校验
2020-12-19 添加springcloud gateway网关
2020-12-21 gateway项目启动时，因为依赖和springboot-start-web冲突导致失败，需要exclude掉web依赖。

## TODO-list
- 链路追踪：Spring Cloud Zipkin
- AOP解决接口重复点击
- netty实现网络调用
- druid数据库连接池集成
- alibaba事务添加
- jenkins自动部署