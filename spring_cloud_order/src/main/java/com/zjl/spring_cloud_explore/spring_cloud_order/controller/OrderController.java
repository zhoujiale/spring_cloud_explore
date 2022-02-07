package com.zjl.spring_cloud_explore.spring_cloud_order.controller;

import com.zjl.commons.util.response.WebResponse;
import com.zjl.spring_cloud_explore.spring_cloud_order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhou
 * @version 1.0
 * @className OrderController
 * @description
 * @date 2022/02/07 16:22
 **/
@Slf4j
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/createOrder")
    public WebResponse createOrder(@RequestParam(value = "customerId")Long customerId,
                                   @RequestParam(value = "productSn")String productSn,
                                   @RequestParam(value = "productCount")Integer productCount){
        orderService.create(customerId,productCount,productSn);
        return WebResponse.success();
    }
}
