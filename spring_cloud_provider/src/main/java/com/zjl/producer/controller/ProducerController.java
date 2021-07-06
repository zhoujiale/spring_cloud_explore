package com.zjl.producer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zjl.commons.util.response.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: ProducerController
 * @description:
 * @author: zhou
 * @create: 2021-06-23 00:40
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ProducerController {

    @GetMapping("/data")
    @HystrixCommand(fallbackMethod = "errorCallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public WebResponse getData(@RequestParam(value = "name") String name) {
        log.info("远程调用");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return WebResponse.success(name + "hello");
    }

    public WebResponse errorCallback(@RequestParam(value = "name")String name){
       return WebResponse.fail("500","服务内部错误");
    }
}
