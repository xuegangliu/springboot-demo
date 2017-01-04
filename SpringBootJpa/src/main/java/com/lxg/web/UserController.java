package com.lxg.web;

import com.lxg.domain.User;
import com.lxg.domain.UserRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 刘雪岗 on 2017/1/4.
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "用户列表查询",notes = "显示所有用户")
    @RequestMapping(value = "/list.action",method = RequestMethod.GET)
    public String list(ModelMap map){
        map.addAttribute("des","用户列表显示");
        map.addAttribute("users",userRepository.findAll());
        return "user/list";
    }

    @ApiOperation(value = "添加用户",notes = "单个用户添加")
    @ApiImplicitParam(name = "user",value = "用户实体类",required = true,dataType = "User")
    @RequestMapping(value = "/add.action",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody User user){
        userRepository.save(user);
    }

//    @ApiOperation(value = "删除用户",notes = "根据id删除用户")
//    @ApiImplicitParam(name = "id",value = "用户主键",required = true,dataType = "Integer")
//    @RequestMapping(value = "/del.action/{id}",method = RequestMethod.DELETE)
//    @ResponseBody
//    public void del(@PathVariable Integer id){
//        userRepository.delete(id);
//    }
}
