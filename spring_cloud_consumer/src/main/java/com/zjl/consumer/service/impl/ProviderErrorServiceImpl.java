package com.zjl.consumer.service.impl;

import com.zjl.commons.util.response.WebResponse;
import com.zjl.consumer.service.ProviderService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhou
 * @version 1.0
 * @className ProducerErrorServiceImpl
 * @description
 * @date 2021/07/06 18:26
 **/
@Component
public class ProviderErrorServiceImpl implements FallbackFactory<ProviderService> {
    @Override
    public ProviderService create(Throwable throwable) {
        return new ProviderService() {
            @Override
            public WebResponse getData(String name) {
                return WebResponse.fail("500","远程服务不可用");
            }
        };
    }
}
