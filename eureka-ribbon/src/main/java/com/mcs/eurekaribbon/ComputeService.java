package com.mcs.eurekaribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class ComputeService {
    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "addFallback")
    public String add() {
        return restTemplate.getForObject("http://eureka-client/add?a=10&b=20", String.class);
    }

    public String addFallback() {
        return "error";
    }

}
