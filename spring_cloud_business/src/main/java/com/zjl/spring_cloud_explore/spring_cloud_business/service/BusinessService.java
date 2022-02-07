package com.zjl.spring_cloud_explore.spring_cloud_business.service;

/**
 * @author zhou
 * @className BusinessService
 * @date 2022/02/07 17:52
 * @description
 **/
public interface BusinessService {
    
    /**
     * @description 提交订单
     * @author zhou
     * @create 2022/2/7 17:59
     * @param 
     * @return void
     **/
    void commitOrder(Long customerId, Integer productCount, String productSn);
}
