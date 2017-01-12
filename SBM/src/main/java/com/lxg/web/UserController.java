package com.lxg.web;

import com.lxg.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 刘雪岗 on 2017/1/12.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "用户列表",notes = "所有用户")
    @RequestMapping(value = "/list.action",method = RequestMethod.GET)
    public String list(ModelMap map){
        map.addAttribute("users",userMapper.findAll());
        return "user/list";
    }

    @ApiOperation(value = "用户删除")
    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public void delById(@PathVariable Long id, HttpServletResponse response){
        userMapper.deleteById(id);
        try {
            response.sendRedirect("/user/list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
