package com.zjl.spring_cloud_explore.spring_cloud_stock.controller;

import com.zjl.commons.util.response.WebResponse;
import com.zjl.spring_cloud_explore.spring_cloud_stock.model.StockPO;
import com.zjl.spring_cloud_explore.spring_cloud_stock.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhou
 * @version 1.0
 * @className StockController
 * @description
 * @date 2022/02/07 16:10
 **/
@Slf4j
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping(value = "/subStock")
    public WebResponse subStock(@RequestParam(value = "productSn")String productSn,
                                @RequestParam(value = "productCount")Integer productCount){
        stockService.deduct(productSn, productCount);
        return WebResponse.success();
    }

    @GetMapping(value = "/queryPrice")
    public WebResponse queryPrice(@RequestParam(value = "productSn")String productSn){
        StockPO stockPO = stockService.queryOne(productSn);
        return WebResponse.success(stockPO.getPrice());
    }
}
