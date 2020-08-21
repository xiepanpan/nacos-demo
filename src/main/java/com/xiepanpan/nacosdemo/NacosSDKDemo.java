package com.xiepanpan.nacosdemo;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

/**
 * @author: xiepanpan
 * @Date: 2020/8/21
 * @Description:  不使用注解 使用客户端进行连接nacos 读取信息
 */
public class NacosSDKDemo {

    public static void main(String[] args) {
        String serverAddr = "localhost:8848";
        String dataId = "example";
        String groupId = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr",serverAddr);

        try {
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = null;
            content = configService.getConfig(dataId, groupId, 3000);
            System.out.println(content);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }
}
