package com.zjl.spring_cloud_explore.spring_cloud_business.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author zhou
 * @version 1.0
 * @className FeignRequestInterceptor
 * @description 重写feign 的请求头，添加自定义的参数。目的将分布式事务的Xid传递到下游
 * @date 2022/02/09 12:28
 **/
@Slf4j
@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String xid = RootContext.getXID();
        log.info("拦截xid:{}",xid);
        if (StringUtils.isNotBlank(xid)){
            requestTemplate.header(RootContext.KEY_XID,xid);
        }
    }
}
