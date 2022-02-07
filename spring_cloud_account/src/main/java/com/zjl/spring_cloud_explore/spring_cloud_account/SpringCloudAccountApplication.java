package com.zjl.spring_cloud_explore.spring_cloud_account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAccountApplication.class, args);
    }

}
