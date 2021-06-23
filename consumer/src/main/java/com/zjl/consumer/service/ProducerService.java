package com.zjl.consumer.service;

import com.zjl.commons.util.WebResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: zhou
 * @Date: 2021-06-23 23:57
 * @Description:
 */
@FeignClient(value = "producer",url = "localhost:8084/producer/")
public interface ProducerService {

    @GetMapping(value = "/api/data")
    WebResponse getData(@RequestParam(value = "name") String name);
}
