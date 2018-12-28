package com.lxg.consumerservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://user-service/user",String.class).getBody();
    }
}
