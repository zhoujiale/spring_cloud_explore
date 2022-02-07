package com.zjl.spring_cloud_explore.spring_cloud_account.service;

import java.math.BigDecimal;

/**
 * @author zhou
 * @className AccountService
 * @description 账号服务
 * @date 2022/02/07 10:47
 **/
public interface AccountService {
    
    /**
     * @description 账户余额扣除
     * @author zhou
     * @create 2022/2/7 11:04 
     * @param customerId 用户id
     * @param money 金额
     * @return void
     **/
    void debit(Long customerId, BigDecimal money);
}
