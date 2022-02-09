package com.zjl.spring_cloud_explore.spring_cloud_stock.service.impl;

import com.zjl.commons.util.constant.ResultCode;
import com.zjl.commons.util.error.BusinessException;
import com.zjl.spring_cloud_explore.spring_cloud_stock.model.StockPO;
import com.zjl.spring_cloud_explore.spring_cloud_stock.repository.StockRepository;
import com.zjl.spring_cloud_explore.spring_cloud_stock.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author zhou
 * @version 1.0
 * @className StockServiceImpl
 * @description
 * @date 2022/02/07 15:39
 **/
@Slf4j
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public void deduct(String productSn, Integer productCount) {
        stockRepository.subCount(productSn, productCount);
    }

    @Override
    public StockPO queryOne(String productSn) {
        StockPO stockPO = stockRepository.findStockPOByProductSnEquals(productSn);
        if (null == stockPO){
            log.error("查询不到商品");
            throw new BusinessException(ResultCode.STOCK_EMPTY);
        }
        return stockPO;
    }


    @Override
    public StockPO createStock(BigDecimal price, Integer count) {
        StockPO stockPO = new StockPO();
        stockPO.setProductSn(UUID.randomUUID().toString().replaceAll("-",""));
        stockPO.setPrice(price);
        stockPO.setProductCount(count);
        stockRepository.save(stockPO);
        return stockPO;
    }
}
