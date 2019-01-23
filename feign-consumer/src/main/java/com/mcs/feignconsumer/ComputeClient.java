package com.mcs.feignconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Primary
@FeignClient(value = "eureka-client", fallback = ComputeClientHystrix.class)
public interface ComputeClient {

    @GetMapping("/add")
    Integer add(@RequestParam Integer a, @RequestParam Integer b);
}