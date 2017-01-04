package com.lxg.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by 刘雪岗 on 2017/1/4.
 */

/**
 * 模板引擎使用
 */
@Controller
public class IndexController {

    @ApiIgnore  // Swagger2 文档忽略
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.addAttribute("name","首页");
        return "index";
    }
}
