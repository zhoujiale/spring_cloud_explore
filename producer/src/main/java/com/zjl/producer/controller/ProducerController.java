package com.zjl.producer.controller;

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
    public WebResponse getData(@RequestParam(value = "name") String name) {
        log.info("远程调用");
        return WebResponse.success(name + "hello");
    }
}
