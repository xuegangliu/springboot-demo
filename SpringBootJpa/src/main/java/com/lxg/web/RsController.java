package com.lxg.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 刘雪岗 on 2017/1/4.
 */
@RestController
@RequestMapping(value = "/rest")
public class RsController {

    @ApiOperation(value = "rest请求",notes = "@RestController--------")
    @RequestMapping(value = "/index.action",method = RequestMethod.GET)
    public String rest(ModelMap map){
        map.addAttribute("name","@RestController的应用");
        return "rest/index";
    }
}
