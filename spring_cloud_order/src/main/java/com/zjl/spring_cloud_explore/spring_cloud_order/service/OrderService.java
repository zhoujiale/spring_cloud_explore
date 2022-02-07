package com.zjl.spring_cloud_explore.spring_cloud_order.service;


import com.zjl.spring_cloud_explore.spring_cloud_order.model.OrderPO;

/**
 * @author zhou
 * @className OrderService
 * @date 2022/02/07 10:41
 * @description 订单服务
 **/
public interface OrderService {

    /**
     * @description 创建订单
     * @author zhou
     * @create 2022/2/7 10:55 
     * @param customerId 用户id
     * @return com.zjl.spring_cloud_explore.spring_cloud_order.model.OrderPO
     **/
    OrderPO create(Long customerId, Integer productCount, String productSn);
}
