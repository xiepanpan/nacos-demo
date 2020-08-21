package com.xiepanpan.nacosdemo;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiepanpan
 * @Date: 2020/8/21
 * @Description:
 */

@NacosPropertySource(dataId = "example",groupId = "DEFAULT_GROUP",autoRefreshed = true)
@RestController
public class NacosConfigController {

    /**
     * 当前的info这个属性 回去nacos-server找到对应的这个属性
     * 高可用
     * hello表示本地属性 （降级属性）
     */
    @NacosValue(value = "${info: hello }",autoRefreshed = true)
    private String info;

    @GetMapping("/get")
    public String get(){
        return info;
    }
}
