package com.zjl.spring_cloud_explore.spring_cloud_business.controller;

import com.zjl.commons.util.response.WebResponse;
import com.zjl.spring_cloud_explore.spring_cloud_business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhou
 * @version 1.0
 * @className BusinessController
 * @description
 * @date 2022/02/07 17:45
 **/
@RestController
@RequestMapping(value = "/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @PostMapping(value = "/commit")
    public WebResponse commitOrder(@RequestParam(value = "customerId")Long customerId,
                                   @RequestParam(value = "productSn")String productSn,
                                   @RequestParam(value = "productCount")Integer productCount){
        businessService.commitOrder(customerId,productCount,productSn);
       return WebResponse.success();
    }
}
