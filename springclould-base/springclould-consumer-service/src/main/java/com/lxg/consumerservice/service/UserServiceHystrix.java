package com.lxg.consumerservice.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class UserServiceHystrix implements UserService {

    @Override
    public String getUser() {
        return "error";
    }
}