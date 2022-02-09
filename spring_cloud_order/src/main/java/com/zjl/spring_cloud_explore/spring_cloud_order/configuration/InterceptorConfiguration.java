package com.zjl.spring_cloud_explore.spring_cloud_order.configuration;

import com.zjl.spring_cloud_explore.spring_cloud_order.interceptor.SeataInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhou
 * @version 1.0
 * @className InterceptorConfiguration
 * @description
 * @date 2022/02/09 12:14
 **/
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Bean
    public SeataInterceptor seataInterceptor(){
        return new SeataInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(seataInterceptor())
                .addPathPatterns("/**");
    }
}
