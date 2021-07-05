package com.zjl.spring_cloud_zuul.config;

import com.zjl.spring_cloud_zuul.filter.SelfFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhou
 * @version 1.0
 * @className ZuulConfiguration
 * @description 路由配置类
 * @date 2021/07/05 10:59
 **/
@Configuration
public class ZuulConfiguration {

    @Bean
    public SelfFilter selfFilter(){
        return new SelfFilter();
    }
}
