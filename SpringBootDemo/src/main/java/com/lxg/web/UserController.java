package com.lxg.web;

import com.lxg.entity.User;
import com.lxg.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by 刘雪岗 on 2017/1/3.
 */

/**
 * swagger2文档测试
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     */
    @ApiOperation(value = "获取用户列表",notes = "Get方式获取列表") //  swagger2文档描述
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getUserList(ModelMap map){
        List<User> list = userService.findAll();
        map.addAttribute("users",list);
        return "user";
    }

    /**
     * 添加用户
     * @param user
     */
    @ApiOperation(value = "添加用户",notes = "添加单个用户到数据库") //  swagger2文档描述
    @ApiImplicitParam(name = "user",value = "用户实体user",required = true,dataType = "User") //  swagger2文档描述
    @RequestMapping(value = "/add.action",method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.create(user.getName(),user.getAge());
    }

    /**
     * 修改用户
     * @param user
     */
    @ApiOperation(value = "用户修改",notes = "单个用户修改")  //  swagger2文档描述
    //  swagger2文档描述
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/modify.action",method = RequestMethod.POST)
    public void modify(@RequestBody User user){
        userService.updateUser(user);
    }
}
