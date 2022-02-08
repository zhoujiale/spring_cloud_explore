package com.zjl.spring_cloud_explore.spring_cloud_order.fegin;

import com.zjl.commons.util.response.WebResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhou
 * @className StockFeignClient
 * @date 2022/02/07 17:08
 * @description
 **/
@FeignClient(name = "stock-service",path = "/stock")
public interface StockFeignClient {

    @GetMapping(value = "/stock/queryPrice")
    WebResponse queryMoney(@RequestParam(value = "productSn")String productSn);
}
