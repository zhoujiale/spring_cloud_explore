package com.zjl.spring_cloud_explore.spring_cloud_order.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhou
 * @version 1.0
 * @className FeignLogConfiguration
 * @description
 * @date 2022/02/09 11:51
 **/
@Configuration
public class FeignLogConfiguration {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
