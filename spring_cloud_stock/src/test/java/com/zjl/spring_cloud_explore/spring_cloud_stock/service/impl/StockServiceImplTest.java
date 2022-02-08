package com.zjl.spring_cloud_explore.spring_cloud_stock.service.impl;

import com.zjl.spring_cloud_explore.spring_cloud_stock.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockServiceImplTest {

    @Autowired
    private StockService stockService;

    @Test
    void createStock() {
        stockService.createStock(new BigDecimal(12.3),100);
    }
}