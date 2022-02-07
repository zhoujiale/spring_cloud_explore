package com.zjl.spring_cloud_explore.spring_cloud_stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStockApplication.class, args);
    }

}
