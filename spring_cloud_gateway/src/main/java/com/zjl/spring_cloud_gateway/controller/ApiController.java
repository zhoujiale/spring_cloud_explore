package com.zjl.spring_cloud_gateway.controller;

import com.zjl.commons.util.response.WebResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhou
 * @version 1.0
 * @className ApiController
 * @description
 * @date 2021/07/08 15:23
 **/
@RestController
public class ApiController {

    @ApiOperation(value = "网关熔断请求")
    @GetMapping(value = "/fallback")
    public WebResponse fallback(){
        return WebResponse.fail("500","服务不可用");
    }
}
