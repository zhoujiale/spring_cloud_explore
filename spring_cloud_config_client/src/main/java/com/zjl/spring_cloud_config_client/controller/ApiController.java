package com.zjl.spring_cloud_config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhou
 * @version 1.0
 * @className ApiController
 * @description
 * @date 2021/05/06 15:52
 **/
@RefreshScope
@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @Value("${username}")
    private String userName;

    @GetMapping(value = "/name")
    public String getUserName(){
        return userName;
    }
}
