package com.zjl.consumer.service;

import com.zjl.commons.util.response.WebResponse;
import com.zjl.consumer.service.impl.ProviderErrorServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: zhou
 * @Date: 2021-06-23 23:57
 * @Description:
 */
@FeignClient(value = "provider-service",path = "/provider",fallback = ProviderErrorServiceImpl.class)
public interface ProviderService {

    @GetMapping(value = "/api/data")
    WebResponse getData(@RequestParam(value = "name") String name);
}
