package com.lxg.wechat.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController
 * <p>
 * This is description
 *
 * @author xuegangliu 2019/06/19
 * @since 1.8
 **/
@RequestMapping(value = "/")
@RestController
public class IndexController {

    @RequestMapping(value = "/")
    public String home(){
        return "This is WeChatPublic Server";
    }
}
