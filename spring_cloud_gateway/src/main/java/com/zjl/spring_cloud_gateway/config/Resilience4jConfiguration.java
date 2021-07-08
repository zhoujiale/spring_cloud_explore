package com.zjl.spring_cloud_gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhou
 * @version 1.0
 * @className Resilience4jConfiguration
 * @description
 * @date 2021/07/08 15:18
 **/
@Slf4j
@Configuration
public class Resilience4jConfiguration {

    //@Bean
    //public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
    //    return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
    //            .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
    //            .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build()).build());
    //}


}
