package com.lxg.userservice.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

/**
 * @author lxg
 */
@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/user" ,method = RequestMethod.GET)
    public String getUser(HttpServletRequest request){
        return "this is user-service return";
    }
}
