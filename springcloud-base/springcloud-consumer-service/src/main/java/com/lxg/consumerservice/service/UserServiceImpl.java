package com.lxg.consumerservice.service;

import org.springframework.stereotype.Component;

/**
 * @author lxg
 */
@Component
public class UserServiceImpl implements UserService {

    @Override
    public String getUser() {
        return "this is error is user-service id down";
    }
}