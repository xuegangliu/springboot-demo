package com.lxg.sample.web;

import com.lxg.sample.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author 刘雪岗 on 2017/1/4.
 * 异常测试
 */
@ApiIgnore
@Controller
@RequestMapping(value = "/error")
public class ErrorController {

    @RequestMapping("/object")
    public String object() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
}
