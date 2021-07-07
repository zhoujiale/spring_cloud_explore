package com.zjl.spring_cloud_gateway.config;

import org.springframework.cloud.gateway.handler.predicate.AfterRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.BeforeRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.BetweenRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.CookieRoutePredicateFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        AfterRoutePredicateFactory afterRoutePredicateFactory = new AfterRoutePredicateFactory();
        AfterRoutePredicateFactory.Config afterConfig = new AfterRoutePredicateFactory.Config();
        LocalDateTime afterDateTime = LocalDateTime.of(2021, 7, 7, 16, 25, 0);
        afterConfig.setDatetime(afterDateTime.atZone(ZoneId.of(zoneStr)));

        BeforeRoutePredicateFactory beforeRoutePredicateFactory = new BeforeRoutePredicateFactory();
        BeforeRoutePredicateFactory.Config beforeConfig = new BeforeRoutePredicateFactory.Config();
        LocalDateTime beforeDateTime = LocalDateTime.of(2021, 7, 7, 15, 37, 0);
        beforeConfig.setDatetime(beforeDateTime.atZone(ZoneId.of(zoneStr)));

        BetweenRoutePredicateFactory betweenRoutePredicateFactory = new BetweenRoutePredicateFactory();
        BetweenRoutePredicateFactory.Config betweenConfig = new BetweenRoutePredicateFactory.Config();
        LocalDateTime startDateTime = LocalDateTime.of(2021, 7, 7, 15, 50);
        LocalDateTime endDateTime = LocalDateTime.of(2021, 7, 7, 21, 55);
        betweenConfig.setDatetime1(startDateTime.atZone(ZoneId.of(zoneStr)));
        betweenConfig.setDatetime2(endDateTime.atZone(ZoneId.of(zoneStr)));

        CookieRoutePredicateFactory cookieRoutePredicateFactory = new CookieRoutePredicateFactory();
        CookieRoutePredicateFactory.Config cookieConfig = new CookieRoutePredicateFactory.Config();
        cookieConfig.setName("UserName");
        cookieConfig.setRegexp("^[a-z]*$");
        return routeBuilder.routes()
                .route("consumer-service", r ->
                        r.path("/consumer/**")
                                .uri("lb://consumer-service")
                )
                .route("before-route", r ->
                        r.path("/provider/api/beforeRoute")
                                .uri("lb://provider-service")
                                .predicate(beforeRoutePredicateFactory.apply(beforeConfig))

                )
                .route("between-route", r ->
                        r.path("/provider/api/betweenRoute")
                                .uri("lb://provider-service")
                                .predicate(betweenRoutePredicateFactory.apply(betweenConfig))
                )
                .route("after-route", r ->
                        r.path("/provider/api/afterRoute")
                                .uri("lb://provider-service")
                                //.predicate(afterRoutePredicateFactory.apply(afterConfig))
                )
                .route("cookie-route", r ->
                        r.path("/provider/api/cookieRoute")
                                .uri("lb://provider-service")
                                .predicate(cookieRoutePredicateFactory.apply(cookieConfig)))
                .build();
    }
}
