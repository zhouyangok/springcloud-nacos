2020-12-05
启动问题：com.alibaba.nacos.api.exception.NacosException: endpoint is blank
  原因：common包中，添加了nacos的配置依赖，而当前服务中没有用到
2020-12-06  
将order-server中配置放在nacos的配置文件中；  
添加mybatisPlus条件查询；  
添加配置文件，打印mybatis的sql日志