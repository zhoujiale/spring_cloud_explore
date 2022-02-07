package com.zjl.spring_cloud_explore.spring_cloud_account.controller;

import com.zjl.commons.util.response.WebResponse;
import com.zjl.spring_cloud_explore.spring_cloud_account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author zhou
 * @version 1.0
 * @className AccountController
 * @description
 * @date 2022/02/07 15:19
 **/
@Slf4j
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * @description 扣减余额
     * @author zhou
     * @create 2022/2/7 15:24 
     * @param 
     * @return com.zjl.commons.util.response.WebResponse
     **/
    @PostMapping(value = "/subMoney")
    public WebResponse subMoney(@RequestParam(value = "customerId")Long customerId,
                                @RequestParam(value = "money")BigDecimal money){
        accountService.debit(customerId, money);
        return WebResponse.success();
    }
}
