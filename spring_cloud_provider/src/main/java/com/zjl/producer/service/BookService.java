package com.zjl.producer.service;

/**
 * @author zhou
 * @className BookService
 * @date 2022/02/07 10:46
 * @description 商品服务
 **/
public interface BookService {

    /**
     * @description 扣减仓储
     * @author zhou
     * @create 2022/2/7 11:01
     * @param bookCount 商品数量
     * @param bookId 商品id
     * @return void
     **/
    void deduct(Long bookId,Integer bookCount);
}
