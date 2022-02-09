package com.zjl.spring_cloud_explore.spring_cloud_order.interceptor;

import io.seata.core.context.RootContext;
import io.seata.integration.http.XidResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhou
 * @version 1.0
 * @className SeataInterceptor
 * @description
 * @date 2022/02/09 12:10
 **/
@Slf4j
public class SeataInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //上下文获取xid
        String xid = RootContext.getXID();
        //请求头获取远程XID
        String rpcXid = request.getHeader(RootContext.KEY_XID);
        log.info("xid:{},rpcXid:{}", xid, rpcXid);
        if (log.isDebugEnabled()) {
            log.debug("xid in RootContext[{}] xid in HttpContext[{}]", xid, rpcXid);
        }
        if (rpcXid != null) {
            //上下文绑定
            RootContext.bind(rpcXid);
            if (log.isDebugEnabled()) {
                log.debug("bind[{}] to RootContext", rpcXid);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
        if (RootContext.inGlobalTransaction()) {
            XidResource.cleanXid(request.getHeader(RootContext.KEY_XID));
        }
    }
}
