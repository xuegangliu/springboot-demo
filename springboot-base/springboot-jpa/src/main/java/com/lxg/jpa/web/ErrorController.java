package com.lxg.jpa.web;

import com.lxg.jpa.exception.MyException;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 刘雪岗 on 2017/1/4.
 */
@Controller
@RequestMapping(value = "/error")
public class ErrorController {

    @ApiOperation(value = "异常处理object",notes = "返回原生error页面")
    @RequestMapping(value = "/object.action",method = RequestMethod.GET)
    public void object(){
        new Exception("object");
    }

    @ApiOperation(value = "异常处理json",notes = "返回自定义error页面")
    @RequestMapping(value = "/json.action",method = RequestMethod.GET)
    public void json(){
        new MyException("自定义异常");
    }
}
