package com.zjl.spring_cloud_alibaba_sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.*;

/**
 * @classname: DemoController
 * @user: zhou
 * @description:
 * @date: 2023/2/2 14:17
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(value = "name")String name){
        return name;
    }

    @GetMapping("/time")
    public String time(@RequestParam(value = "uid")String uid){
        return uid;
    }

    @GetMapping("/local/{name}")
    @SentinelResource(value = "local",blockHandler = "blockHandlerForLocal")
    public String local(@PathVariable(value = "name")String name){
        return name;
    }

    public String blockHandlerForLocal(String name, BlockException e){
        return "default";
    }
}
