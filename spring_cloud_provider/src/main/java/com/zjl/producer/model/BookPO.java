package com.zjl.producer.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author zhou
 * @version 1.0
 * @className BookPO
 * @description 书本类
 * @date 2022/01/27 16:26
 **/
@Data
@Entity
@Table(name = "tb_book")
@org.hibernate.annotations.Table(appliesTo = "tb_book",comment = "书本表")
public class BookPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,columnDefinition = "bigint(20) comment '主键id'")
    private Long id;

    @Column(name = "book_name",nullable = false,columnDefinition = "varchar(45) comment '书名'")
    private String bookName;

    @Column(name = "book_number",nullable = false,columnDefinition = "int(11) default 0 comment '数目'")
    private Integer bookNumber;

    @Column(name = "price",nullable = false,columnDefinition = "decimal(5,2) default 0 comment '价格'")
    private BigDecimal price;
}
