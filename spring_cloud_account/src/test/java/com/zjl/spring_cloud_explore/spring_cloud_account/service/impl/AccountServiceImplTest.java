package com.zjl.spring_cloud_explore.spring_cloud_account.service.impl;

import com.zjl.spring_cloud_explore.spring_cloud_account.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    void createAccount() {
        accountService.createAccount("zjl",new BigDecimal(1000));
    }
}