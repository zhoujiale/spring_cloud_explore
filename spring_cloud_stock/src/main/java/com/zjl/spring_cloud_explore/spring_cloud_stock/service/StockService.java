package com.zjl.spring_cloud_explore.spring_cloud_stock.service;

import com.zjl.spring_cloud_explore.spring_cloud_stock.model.StockPO;

/**
 * @author zhou
 * @className StockService
 * @date 2022/02/07 15:37
 * @description 商品服务
 **/
public interface StockService {

    /**
     * @description 扣减库存
     * @author zhou
     * @create 2022/2/7 15:39
     * @param productCount 商品数量
     * @param productSn 商品编号
     * @return void
     **/
    void deduct(String productSn,Integer productCount);

    /**
     * @description 查询商品
     * @author zhou
     * @create 2022/2/7 17:04
     * @param productSn 商品编号
     * @return com.zjl.spring_cloud_explore.spring_cloud_stock.model.StockPO
     **/
    StockPO queryOne(String productSn);
}
