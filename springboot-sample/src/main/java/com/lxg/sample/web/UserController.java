package com.lxg.sample.web;

import com.lxg.sample.entity.User;
import com.lxg.sample.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    UserService userService;

    /**
     * 获取用户列表
     */
    @ApiOperation(value = "获取用户列表",notes = "Get方式获取列表") //  swagger2文档描述
    @RequestMapping(value = "list.action",method = RequestMethod.GET)
    public String getUserList(ModelMap map){
        List<User> list = userService.findAll();
        map.addAttribute("users",list);
        return "user/user";
    }

    /**
     * 添加用户
     * @param user
     */
    @ApiOperation(value = "添加用户",notes = "添加单个用户到数据库") //  swagger2文档描述
    @ApiImplicitParam(name = "user",value = "用户实体user",required = true,dataType = "User") //  swagger2文档描述
    @RequestMapping(value = "/add.action",method = RequestMethod.POST)
    public void addUser(@RequestBody User user, HttpServletResponse response){
        userService.create(user.getName(),user.getAge());
        try {
            response.sendRedirect("/user/list.action");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void modify(@RequestBody User user,HttpServletResponse response){
        userService.updateUser(user);
        try {
            response.sendRedirect("user/list.action");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按id删除用户
     * @param id
     */
    @ApiOperation(value = "用户删除",notes = "按用户主键删除用户")  //  swagger2文档描述
    @ApiImplicitParam(name = "id",value = "用户主键",required = true,dataType = "Integer")  //  swagger2文档描述
    @RequestMapping(value = "/del.action/{id}",method = RequestMethod.GET)
    public void delById(@PathVariable Integer id,HttpServletResponse response){
        userService.deleteById(id);
        try {
            response.sendRedirect("/user/list.action");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加页面
     * @return
     */
    @ApiIgnore
    @RequestMapping("/goAdd.action")
    public String goAdd(){
        return "user/add";
    }
}
