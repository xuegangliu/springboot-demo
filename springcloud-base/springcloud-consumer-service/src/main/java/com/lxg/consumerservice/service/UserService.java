package com.lxg.consumerservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lxg
 */
@FeignClient(value = "user-service",fallback = UserServiceImpl.class)
public interface UserService {

    /**
     * getUser
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/user")
    String getUser();
}
