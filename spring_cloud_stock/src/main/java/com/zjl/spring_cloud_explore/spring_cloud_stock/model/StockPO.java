package com.zjl.spring_cloud_explore.spring_cloud_stock.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author zhou
 * @version 1.0
 * @className StockPO
 * @description
 * @date 2022/02/07 15:30
 **/
@Data
@Entity
@Table(name = "tb_stock")
@org.hibernate.annotations.Table(appliesTo = "tb_stock",comment = "库存商品")
public class StockPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,columnDefinition = "bigint(20) comment '主键'")
    private Long id;

    @Column(name = "product_sn",nullable = false,unique = true,columnDefinition = "varchar(32) comment '商品编号'")
    private String productSn;

    @Column(name = "price",nullable = false,columnDefinition = "decimal(7,2) comment '价格'")
    private BigDecimal price;

    @Column(name = "product_count",nullable = false,columnDefinition = "int(11) default 0 comment '库存'")
    private Integer productCount;


}
