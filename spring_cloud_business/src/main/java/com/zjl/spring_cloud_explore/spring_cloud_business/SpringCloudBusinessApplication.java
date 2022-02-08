package com.zjl.spring_cloud_explore.spring_cloud_business;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableAutoDataSourceProxy
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudBusinessApplication.class, args);
    }

}
