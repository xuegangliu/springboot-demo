package com.lxg.jpa.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by 刘雪岗 on 2017/1/4.
 */

@SuppressWarnings("ALL")
@Controller
@RequestMapping(value = "")
public class IndexController {

    @ApiIgnore
    @RequestMapping(value = "")
    public String index(ModelMap map){
        map.addAttribute("index","这里是首页(从/传入)");
        map.addAttribute("user","跳转user");
        map.addAttribute("rest","跳转rest");
        return "index";
    }
}
