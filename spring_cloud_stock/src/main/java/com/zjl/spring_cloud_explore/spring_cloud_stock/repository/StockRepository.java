package com.zjl.spring_cloud_explore.spring_cloud_stock.repository;

import com.zjl.spring_cloud_explore.spring_cloud_stock.model.StockPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author zhou
 * @className StockRepository
 * @date 2022/02/07 15:36
 * @description
 **/
public interface StockRepository extends JpaRepository<StockPO,Long> {

    @Modifying
    @Query(value = "update StockPO as s set s.productCount = s.productCount - :productCount where s.productSn = :productSn and s.productCount > :productCount")
    int subCount(@Param("productSn") String productSn,@Param("productCount") Integer productCount);

    StockPO findStockPOByProductSnEquals(String productSn);
}
