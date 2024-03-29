package com.zjl.spring_cloud_explore.spring_cloud_order.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author zhou
 * @version 1.0
 * @className OrderPO
 * @description
 * @date 2022/01/27 16:52
 **/
@Data
@Entity
@Table(name = "tb_order")
@org.hibernate.annotations.Table(appliesTo = "tb_order",comment = "订单表")
public class OrderPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,columnDefinition = "bigint(20) comment '主键'")
    private Long id;

    @Column(name = "account_id",nullable = false,columnDefinition = "bigint(20) comment '账户id'")
    private Long accountId;

    @Column(name = "productSn",nullable = false,columnDefinition = "varchar(32) comment '商品编号'")
    private String productSn;

    @Column(name = "number",nullable = false,columnDefinition = "int(11) default 0 comment '商品数量'")
    private Integer number;

    @Column(name = "total_price",nullable = false,columnDefinition = "decimal(7,2) default 0 comment '订单总价'")
    private BigDecimal totalPrice;
}
