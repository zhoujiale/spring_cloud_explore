package com.zjl.consumer.service;

import com.zjl.commons.util.response.WebResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: zhou
 * @Date: 2021-06-23 23:57
 * @Description:
 */
@Component
@FeignClient(value = "producer-service",path = "/producer")
public interface ProducerService {

    @GetMapping(value = "/api/data")
    WebResponse getData(@RequestParam(value = "name") String name);
}
