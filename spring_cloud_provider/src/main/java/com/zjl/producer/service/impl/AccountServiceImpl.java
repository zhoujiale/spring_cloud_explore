package com.zjl.producer.service.impl;

import com.zjl.producer.repository.AccountRepository;
import com.zjl.producer.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author zhou
 * @version 1.0
 * @className AccountServiceImpl
 * @description
 * @date 2022/02/07 10:47
 **/
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void debit(Long customerId, BigDecimal money) {

    }
}
