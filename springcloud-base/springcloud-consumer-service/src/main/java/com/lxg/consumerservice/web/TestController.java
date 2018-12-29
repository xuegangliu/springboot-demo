package com.lxg.consumerservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//@RefreshScope
public class TestController {

    @Autowired
    RestTemplate restTemplate;

//    @Value("${from}")
//    private String from;
//
//    @RequestMapping("/from")
//    public String from() {
//        return this.from;
//    }
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    public String getFrom() {
//        return from;
//    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://user-service/user",String.class).getBody();
    }
}
