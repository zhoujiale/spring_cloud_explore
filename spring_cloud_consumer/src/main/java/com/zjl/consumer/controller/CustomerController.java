package com.zjl.consumer.controller;

import com.zjl.commons.util.response.WebResponse;
import com.zjl.consumer.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: CustomerController
 * @description:
 * @author: zhou
 * @create: 2021-06-23 23:57
 */
@RestController
public class CustomerController {

    @Autowired
    private ProviderService providerService;

    @GetMapping(value = "/getCustomer")
    public WebResponse getCustomer(@RequestParam(value = "name")String name){
        return providerService.getData(name);
    }

    @GetMapping(value = "/byZuul")
    public WebResponse byZuul(){
        return WebResponse.success("zuul");
    }

    @GetMapping(value = "/byGateway")
    public WebResponse byGateway(){
        return WebResponse.success("gateway");
    }

}
