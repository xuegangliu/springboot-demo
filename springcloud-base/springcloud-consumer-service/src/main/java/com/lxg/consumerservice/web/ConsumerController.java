package com.lxg.consumerservice.web;

import com.lxg.consumerservice.service.UserService;
import com.lxg.consumerservice.utils.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lxg
 */
@RestController
public class ConsumerController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getUserName(HttpServletRequest request) {
        String ip = IpUtils.getIpByHttpServletRequest(request);
        logger.info("consumer-service(/test): request-user-service,IP:{}",ip);
        return userService.getUser();
    }
}
