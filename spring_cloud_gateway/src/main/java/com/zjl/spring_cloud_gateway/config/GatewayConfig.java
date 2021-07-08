package com.zjl.spring_cloud_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;

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
        String zoneStr = "Asia/Shanghai";
        LocalDateTime afterDateTime = LocalDateTime.of(2021, 7, 7, 16, 25, 0);
        LocalDateTime beforeDateTime = LocalDateTime.of(2021, 7, 7, 15, 37, 0);
        LocalDateTime startDateTime = LocalDateTime.of(2021, 7, 7, 15, 50);
        LocalDateTime endDateTime = LocalDateTime.of(2021, 7, 7, 21, 55);

        return routeBuilder.routes()
                .route("consumer-service", r ->
                        r.path("/consumer/**")
                                .uri("lb://consumer-service")
                )
                .route("before-route", r ->
                        r.path("/provider/api/beforeRoute")
                                .and()
                                .before(beforeDateTime.atZone(ZoneId.of(zoneStr)))
                                .uri("lb://provider-service")
                )
                .route("between-route", r ->
                        r.path("/provider/api/betweenRoute")
                                .and()
                                .between(startDateTime.atZone(ZoneId.of(zoneStr)), endDateTime.atZone(ZoneId.of(zoneStr)))
                                .uri("lb://provider-service")
                )
                .route("after-route", r ->
                        r.path("/provider/api/afterRoute")
                                .and()
                                .after(afterDateTime.atZone(ZoneId.of(zoneStr)))
                                .uri("lb://provider-service")
                )
                .route("cookie-route", r ->
                        r.path("/provider/api/cookieRoute")
                                .and()
                                .cookie("UserName", "^[a-z]*$")
                                .uri("lb://provider-service")
                )
                .route("header-route", r ->
                        r.path("/provider/api/headerRoute")
                                .and()
                                .header("Token", "^[a-z]*$")
                                .uri("lb://provider-service")
                )
                .route("query-route", r ->
                        r.path("/provider/api/queryRoute")
                                .and()
                                .query("productName", "^[a-z]*$")
                                .uri("lb://provider-service")
                )
                .route("circuit-route", r ->
                        r.path("/provider/api/filterRoute")
                                .filters(f -> f.circuitBreaker(c -> c.setName("myBreaker").setFallbackUri("forward:/fallback")))
                                .uri("lb://provider-service"))
                .route("retry-route", r ->
                        r.path("/provider/api/retryRoute")
                                .filters(f -> f.retry(c -> c.setRetries(3).setMethods(HttpMethod.GET, HttpMethod.POST).setStatuses(HttpStatus.NOT_FOUND)))
                                .uri("lb://provider-service"))
                .build();
    }
}
