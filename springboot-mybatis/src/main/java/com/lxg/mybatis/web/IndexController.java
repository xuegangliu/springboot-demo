package com.lxg.mybatis.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by 刘雪岗 on 2017/1/12.
 */
@Controller
public class IndexController {

    @ApiIgnore
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
