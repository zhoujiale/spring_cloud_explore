package com.zjl.spring_cloud_zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zjl.spring_cloud_zuul.config.FilterType;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhou
 * @version 1.0
 * @className SelfFilter
 * @description
 * @date 2021/07/05 11:11
 **/
@Slf4j
public class SelfFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterType.PRE.getType();
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取请求上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取当前请求
        HttpServletRequest request = currentContext.getRequest();
        //打印请求
        log.info(String.format("%s request to %s",request.getMethod(),request.getRequestURL().toString()));
        return null;
    }
}
