//package com.lxg.consumerservice.service;
//
//
//import com.netflix.ribbon.proxy.annotation.Hystrix;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class TestService {
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    @Hystrix(cacheKey = "addServiceFallback")
//    public String addService() {
//        return restTemplate.getForEntity("http://user-service/user", String.class).getBody();
//    }
//}
