package com.zjl.spring_cloud_explore.spring_cloud_business.feign;

import com.zjl.commons.util.response.WebResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhou
 * @className StockFeignClient
 * @date 2022/02/07 18:03
 * @description
 **/
@FeignClient(value = "stock-service",path = "/stock")
public interface StockFeignClient {

    @PostMapping(value = "/stock/subStock")
    WebResponse subStock(@RequestParam(value = "productSn")String productSn,@RequestParam(value = "productCount")Integer productCount);
}
