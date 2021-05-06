package com.zjl.spring_cloud_customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudCustomerApplication.class, args);
    }

}
