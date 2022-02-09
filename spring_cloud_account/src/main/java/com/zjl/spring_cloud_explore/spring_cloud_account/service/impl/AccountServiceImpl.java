package com.zjl.spring_cloud_explore.spring_cloud_account.service.impl;

import com.zjl.spring_cloud_explore.spring_cloud_account.model.AccountPO;
import com.zjl.spring_cloud_explore.spring_cloud_account.repository.AccountRepository;
import com.zjl.spring_cloud_explore.spring_cloud_account.service.AccountService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author zhou
 * @version 1.0
 * @className AccountServiceImpl
 * @description
 * @date 2022/02/07 15:04
 **/
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void debit(Long customerId, BigDecimal money) {
        String xid = RootContext.getXID();
        log.info("xid:{}",xid);
        accountRepository.subMoney(customerId, money);
    }

    @Override
    public AccountPO createAccount(String accountName,BigDecimal money) {
        AccountPO accountPO = new AccountPO();
        accountPO.setAccountName(accountName);
        accountPO.setMoney(money);
        accountRepository.save(accountPO);
        return accountPO;
    }
}
