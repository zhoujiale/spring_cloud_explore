package com.zjl.producer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zjl.commons.util.date.DateUtil;
import com.zjl.commons.util.response.WebResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @name: ProducerController
 * @description:
 * @author: zhou
 * @create: 2021-06-23 00:40
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ProviderController {

    @GetMapping("/data")
    @HystrixCommand(fallbackMethod = "errorCallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public WebResponse getData(@RequestParam(value = "name") String name) {
        log.info("远程调用");
        //try {
        //    Thread.sleep(1000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        return WebResponse.success(name + "hello");
    }

    public WebResponse errorCallback(@RequestParam(value = "name")String name){
       return WebResponse.fail("500","服务内部错误");
    }

    @ApiOperation(value = "网关断言期限之后")
    @GetMapping(value = "/afterRoute")
    public WebResponse afterRoute(){
        LocalDateTime now = LocalDateTime.now();
        return WebResponse.success(DateUtil.localDateTimeToStr(now,"yyyy-MM-dd HH:mm:ss")+":之后允许访问");
    }

    @ApiOperation(value = "网关断言期限之前")
    @GetMapping(value = "/beforeRoute")
    public WebResponse beforeRoute(){
        LocalDateTime now = LocalDateTime.now();
        return WebResponse.success(DateUtil.localDateTimeToStr(now,"yyyy-MM-dd HH:mm:ss")+":之前允许访问");
    }

    @ApiOperation(value = "网关断言期限范围内")
    @GetMapping(value = "/betweenRoute")
    public WebResponse betweenRoute(){
        LocalDateTime now = LocalDateTime.now();
        return WebResponse.success(DateUtil.localDateTimeToStr(now,"yyyy-MM-dd HH:mm:ss")+":请求");
    }

    @ApiOperation(value = "网关断言cookie")
    @GetMapping(value = "/cookieRoute")
    public WebResponse cookieRoute(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("UserName")){
                return WebResponse.success("cookie:"+cookie.getValue());
            }
        }
        return WebResponse.fail("500","未找到cookie");
    }
}
