package com.zjl.spring_cloud_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhou
 * @version 1.0
 * @className GatewayConfig
 * @description 路由配置
 * @date 2021/07/05 14:26
 **/
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeBuilder) {
        return routeBuilder.routes()
                .route("consumer-service", r ->
                        r.path("/consumer/**")
                                .uri("lb://consumer-service")
                ).build();
    }
}
