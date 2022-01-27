package com.zjl.consumer.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author zhou
 * @version 1.0
 * @className AccountPO
 * @description
 * @date 2022/01/27 17:27
 **/
@Data
@Entity
@Table(name = "tb_account")
@org.hibernate.annotations.Table(appliesTo = "tb_account",comment = "账户表")
public class AccountPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,columnDefinition = "bigint(20) comment '主键'")
    private Long id;

    @Column(name = "account_name",nullable = false,columnDefinition = "varchar(45) comment '账号'")
    private String accountName;

    @Column(name = "money",nullable = false,columnDefinition = "decimal(7,2) default 0 comment '余额'")
    private BigDecimal money;
}
