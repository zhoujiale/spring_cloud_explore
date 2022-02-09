package com.zjl.spring_cloud_explore.spring_cloud_business.service.impl;

import com.zjl.spring_cloud_explore.spring_cloud_business.feign.OrderFeignClient;
import com.zjl.spring_cloud_explore.spring_cloud_business.feign.StockFeignClient;
import com.zjl.spring_cloud_explore.spring_cloud_business.service.BusinessService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhou
 * @version 1.0
 * @className BusinessServiceImpl
 * @description
 * @date 2022/02/07 17:55
 **/
@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private OrderFeignClient orderFeignClient;
    @Autowired
    private StockFeignClient stockFeignClient;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void commitOrder(Long customerId, Integer productCount, String productSn) {
        stockFeignClient.subStock(productSn, productCount);
        orderFeignClient.createOrder(customerId, productSn, productCount);
        if (true){
            log.error("主动抛出异常");
            throw new RuntimeException();
        }
    }
}
