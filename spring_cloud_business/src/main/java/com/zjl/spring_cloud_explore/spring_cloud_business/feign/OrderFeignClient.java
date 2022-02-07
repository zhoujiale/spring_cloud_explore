package com.zjl.spring_cloud_explore.spring_cloud_business.feign;

import com.zjl.commons.util.response.WebResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhou
 * @className OrderFeignClient
 * @date 2022/02/07 17:59
 * @description
 **/
@FeignClient(name = "order-service")
public interface OrderFeignClient {

    @PostMapping(value = "/createOrder")
    WebResponse createOrder(@RequestParam(value = "customerId") Long customerId, @RequestParam(value = "productSn") String productSn,
                            @RequestParam(value = "productCount") Integer productCount);
}
