package com.lxg.consumerservice.web;

import com.lxg.consumerservice.utils.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

/**
 * @author lxg
 */
@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1(HttpServletRequest request) {
        String ip = IpUtils.getIpByHttpServletRequest(request);
        logger.info("consumer-service(/test1): request-user-service,IP:{}",ip);
        return restTemplate.getForEntity("http://user-service/test1",String.class).getBody();
    }
}
