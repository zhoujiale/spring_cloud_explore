package com.zjl.spring_cloud_explore.spring_cloud_order.fegin;

import com.zjl.commons.util.response.WebResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author zhou
 * @className AccountFeginClient
 * @date 2022/02/07 17:00
 * @description 账号服务
 **/
@FeignClient(name = "account-service")
public interface AccountFeignClient {

    @PostMapping(value = "/subMoney")
    WebResponse subMoney(@RequestParam(value = "customerId")Long customerId, @RequestParam(value = "money")BigDecimal money);
}
