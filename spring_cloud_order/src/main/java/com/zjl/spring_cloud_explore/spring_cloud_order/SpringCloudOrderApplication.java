package com.zjl.spring_cloud_explore.spring_cloud_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOrderApplication.class, args);
    }

}
